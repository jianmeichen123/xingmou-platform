import redis

rc = redis.Redis(host='10.10.0.147')

ps = rc.pubsub()

ps.subscribe(['dev'])
rc.publish('dev', "analysy_report"+":"+"1000453")