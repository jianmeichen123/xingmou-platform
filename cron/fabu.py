import redis
pool=redis.ConnectionPool(host='10.10.0.147',port=6379,db=0)
r = redis.StrictRedis(connection_pool=pool)
while True:
    input = raw_input("publish:")
    if input == 'over':
        break;
    r.publish('excelFile', input)