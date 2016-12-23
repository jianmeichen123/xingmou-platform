#!/usr/bin/python
# -*- coding: utf-8 -*-

import json

import pymongo
import time, MySQLdb

import sys
reload(sys)
sys.setdefaultencoding("utf-8")



industes = ["金融","教育,培训","汽车,交通","本地生活","医疗,健康","企业服务","社交,网络","旅游,户外","硬件","广告,营销","文化,娱乐","体育,运动","物流","房产,服务","电子商务","游戏","工具,软件","云计算,大数据"]


def get_db(host="10.10.0.107", port=27011,dbName="doc"):

    client = pymongo.MongoClient(host=host,port=port)
    db = client[dbName]
    if host == "10.10.0.107":
        db.authenticate(name="xingmou", password="xingmou7pDxcer8", mechanism='SCRAM-SHA-1')
    return db


def get_collection(db,name):
    coll = db[name]
    return coll

sql = "INSERT INTO dm_industry_reports ( title,tags, source_id,source_url, source_type_name, publish_date ,icon, summary_short, year,source_type,summary,doc_type,industry_id,industry_name) " \
      "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s ,%s,%s,%s,%s,%s)"


def analysy_report():
    con = get_collection(get_db(dbName="doc",host="10.10.0.107"),"analysys-report")
    rows = con.find()
    data = []
    for row in rows:
        tags = ""
        if row.has_key("labels") and  row["labels"] != None :
            labels = row["labels"]
            for label in labels:
                if label["name"] != None:
                    tags = tags+label["name"] +","
            if tags != "":
                tags = tags[:-1]

        articeImage = ""
        if row["articeImage"] != None and row["articeImage"] != "":
            articeImage ="/analysys/report/"+ str(row["id"])+"/face.png"

        images =""
        for image in row["datas"]["contents"]["datas"]["images"]:
            images = images+ image +","

        if images != "":
            images = images[:-1]
        t =   time.localtime(float(row["publishDate"]/1000))
        timeStr=time.strftime("%Y-%m-%d %H:%M:%S", t)
        industyId = do_idust(str(row['summary']).strip())
        industyName = ""
        if industyId != -1:
            industyName = industes[industyId].replace(",","")
        source_url = "http://www.analysys.cn/view/report/detail.html?columnId=8&articleId="+str(row["id"])
        param = (row["mainTitle"].strip(),tags.decode('utf8'),str(row["id"]),source_url,row["cname"].strip(),
                 timeStr,articeImage,str(row['summary']).strip(),"2016","1",images,"1",industyId,industyName)
        data.append(param)
    conn=MySQLdb.connect(host="10.9.130.142",user="xmuser",passwd="qcDKywE7Ka52",db="xm_doc",charset="utf8")
    cursor = conn.cursor()
    cursor.executemany(sql,data)
    conn.commit()
    conn

def analysys_review():
    con = get_collection(get_db(dbName="doc",host="10.10.0.107"),"analysys-review")
    rows = con.find()
    data = []
    conn=MySQLdb.connect(host="10.9.130.142",user="xmuser",passwd="qcDKywE7Ka52",db="xm_doc",charset="utf8")
    cursor = conn.cursor()
    for row in rows:
        tags = ""
        if row.has_key("labels") and  row["labels"] != None :
            labels = row["labels"]
            for label in labels:
                if label["name"] != None:
                    tags = tags+label["name"] +","
            if tags != "":
                tags = tags[:-1]

        articeImage = ""
        if row["articeImage"] != None and row["articeImage"] != "":
            articeImage ="/analysys/review/"+ str(row["id"])+"/face.png"

        source_url = "http://www.analysys.cn/view/report/detail.html?columnId=22&articleId="+str(row["id"])
        t =   time.localtime(float(row["publishDate"]/1000))
        timeStr=time.strftime("%Y-%m-%d %H:%M:%S", t)
        industyId = do_idust(str(row['summary']).strip())
        industyName = ""
        if industyId != -1:
          industyName = industes[industyId].replace(",","")
        param = (row["mainTitle"].strip(),tags,str(row["id"]),source_url,row["cname"].strip(),
                 timeStr,articeImage,str(row['summary']).strip(),"2016","1",json.dumps(row['datas']["recommendlist"]),"2",industyId,industyName)
        #data.append(param)
        cursor.execute(sql,param)
    conn.commit()

def iresearch_report():
    con = get_collection(get_db(dbName="doc",host="10.10.0.107"),"iresearch-report")
    rows = con.find()
    data = []
    sql = "INSERT INTO dm_industry_reports ( title,tags, source_id,source_url, source_type_name, publish_date ,icon, summary_short, year,source_type,summary,doc_type,industry_id,industry_name) " \
            "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s ,%s,%s,%s,%s,%s))"

    for row in rows:
        if row["url"].find("20160") !=-1:
            if row.has_key("datas"):
                tags = ""
                if row.has_key("tabs") and  row["tabs"] != None :
                    labels = row["tabs"]
                    for label in labels:
                            tags = tags+label+","
                    if tags != "":
                        tags = tags[:-1]
                img = "/iresearch/report/"+row["id"]+"/face.png"
                industyId = do_idust(str(row['desc']).strip())
                industyName = ""
                if industyId != -1:
                    industyName = industes[industyId].replace(",","")
                param = (row["title"],tags,str(row["id"]),row["url"],row["type"],"2016-"+row["time"],img,str(row['desc']),"2016","2",json.dumps(row["datas"]),"1",industyId,industyName)
                data.append(param)
    conn=MySQLdb.connect(host="10.9.130.142",user="xmuser",passwd="qcDKywE7Ka52",db="xm_doc",charset="utf8")
    cursor = conn.cursor()
    cursor.executemany(sql,data)
    conn.commit()

def iresearch_news():
    con = get_collection(get_db(dbName="doc",host="10.10.0.107"),"iresearch-news")
    rows = con.find({})
    data = []
    sql = "INSERT INTO dm_industry_reports ( title,tags, source_id,source_url, source_type_name, publish_date ,icon, summary_short, year,source_type,summary,doc_type,industry_id,industry_name) " \
          "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s ,%s,%s,%s,%s,%s)"

    for row in rows:
        if row["url"].find("2016") !=-1:
            if row.has_key("html"):
                tags = ""
                if row.has_key("tabs") and  row["tabs"] != None :
                    labels = row["tabs"]
                    for label in labels:
                        tags = tags+label+","
                    if tags != "":
                        tags = tags[:-1]
                img = "/iresearch/news/"+row["id"]+"/face.png"
                time = row["time"]
                if time.count("-") != 2:
                    time = "2016-"+row["time"]
                industyId = do_idust(str(row['desc']).strip())
                industyName = ""
                if industyId != -1:
                    industyName = industes[industyId].replace(",","")
                param = (row["title"],tags,str(row["id"]),row["url"],row["type"],time,img,str(row['desc']),"2016","2",row["html"],"2",industyId,industyName)
                data.append(param)
    conn=MySQLdb.connect(host="10.9.130.142",user="xmuser",passwd="qcDKywE7Ka52",db="xm_doc",charset="utf8")
    cursor = conn.cursor()

    cursor.executemany(sql,data)
    conn.commit()

def do_idust(text):
    i = 0
    for indust in industes:
        if text.find(indust) != -1:
            return i
        for indust2 in indust.split(","):
            if text.find(indust2) != -1:
                return i
        i = i +1
    return -1

if __name__ == '__main__':
    analysy_report()
    analysys_review()
    #iresearch_report()
    iresearch_news()