#!/usr/bin/python
import json
from bson import json_util
from bson.json_util import dumps
import bottle
from bottle import route, run, request, abort, post, get, delete, put
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection['market']
collection = db['stocks']

#function for create
@route('/create', method='POST')
def put_document():
  myDocument = {"Ticker" : request.json.get('Ticker'),
               "Profit Margin" : request.json.get('Profit Margin'),
               "Institutional Ownership" : request.json.get('Institutional Ownership'),
               "EPS growth past 5 years" : request.json.get('EPS growth past 5 years'),
               "Total Debt/Equity" : request.json.get('Total Debt/Equity'),
               "Current Ratio" : request.json.get('Current Ratio'),
                "Return on Assets" : request.json.get('Return on Assets'),
                "Sector" : request.json.get('Sector'),
                "P/S" : request.json.get('P/S'),
                "Change from Open" : request.json.get('Change from Open'),
                "Performance (YTD)" : request.json.get('Performance (YTD)'),
                "Performance (Week)" : request.json.get('Performance (Week)'),
                "Quick Ratio" : request.json.get('Quick Ratio'),
                "Insider Transactions" : request.json.get('Insider Transactions'),
                "P/B" : request.json.get('P/B'),
                "EPS growth quarter over quarter" : request.json.get('EPS growth quarter over quarter'),
                "Payout Ratio" : request.json.get('Payout Ratio'),
                "Performance (Quarter)" : request.json.get('Performance (Quarter)'),
                "Forward P/E" : request.json.get('Forward P/E'),
                "P/E" : request.json.get('P/E'),
                "200-Day Simple Moving Average" : request.json.get('200-Day Simple Moving Average'),
                "Shares Outstanding" : request.json.get('Shares Outstanding'),
                "Earnings Date" : request.json.get('Earnings Date'),
                "52-Week High" : request.json.get('52-Week High'),
                "P/Cash" : request.json.get('P/Cash'),
                "Change" : request.json.get('Change'),
                "Analyst Recom" : request.json.get('Analyst Recom'),
                "Volatility (Week)" : request.json.get('Volatility (Week)'),
                "Country" : request.json.get('Country'),
                "Return on Equity" : request.json.get('Return on Equity'),
                "50-Day Low" : request.json.get('50-Day Low'),
                "Price" : request.json.get('Price'),
                "50-Day High" : request.json.get('50-Day High'),
                "Return on Investment" : request.json.get('Return on Investment'),
                "Shares Float" : request.json.get('Shares Float'),
                "Dividend Yield" : request.json.get('Dividend Yield'),
                "EPS growth next 5 years" : request.json.get('EPS growth next 5 years'),
                "Industry" : request.json.get('Industry'),
                "Beta" : request.json.get('Beta'),
                "Sales growth quarter over quarter" : request.json.get('Sales growth quarter over quarter'),
                "Operating Margin" : request.json.get('Operating Margin'),
                "EPS (ttm)" : request.json.get('EPS (ttm)'),
                "PEG" : request.json.get('PEG'),
                "Float Short" : request.json.get('Float Short'),
                "52-Week Low" : request.json.get('52-Week Low'),
                "Average True Range" : request.json.get('Average True Range'),
                "EPS growth next year" : request.json.get('EPS growth next year'),
                "Sales growth past 5 years" : request.json.get('Sales growth past 5 years'),
                "Company" : request.json.get('Company'),
                "Gap" : request.json.get('Gap'),
                "Relative Volume" : request.json.get('Relative Volume'),
                "Volatility (Month)" : request.json.get('Volatility (Month)'),
                "Market Cap" : request.json.get('Market Cap'),
                "Volume" : request.json.get('Volume'),
                "Gross Margin" : request.json.get('Gross Margin'),
                "Short Ratio" : request.json.get('Short Ratio'),
                "Performance (Half Year)" : request.json.get('Performance (Half Year)'),
                "Relative Strength Index (14)" : request.json.get('Relative Strength Index (14)'),
                "Insider Ownership" : request.json.get('Insider Ownership'),
                "20-Day Simple Moving Average" : request.json.get('20-Day Simple Moving Average'),
                "Performance (Month)" : request.json.get('Performance (Month)'),
                "P/Free Cash Flow" : request.json.get('P/Free Cash Flow'),
                "Institutional Transactions" : request.json.get('Institutional Transactions'),
                "Performance (Year)" : request.json.get('Performance (Year)'),
                "LT Debt/Equity" : request.json.get('LT Debt/Equity'),
                "Average Volume" : request.json.get('Average Volume'),
                "EPS growth this year" : request.json.get('EPS growth this year'),
                "50-Day Simple Moving Average" : request.json.get('50-Day Simple Moving Average')}
  
  collection.insert(myDocument)

#function for read
@route('/get',method='GET')
def read():
  ticker = request.query.ticker
  myQuery = dumps(collection.find({"Ticker" : ticker}))
  print (myQuery)
  

#function for update
@route('/update', method='GET')
def update():
  ticker = request.query.ticker
  country = request.query.country
  myQuery = dumps(collection.find({"Ticker" : ticker}))
  newvalues = { "$set": {"Country" : "Poland"}}
  
  result = collection.update({"Ticker": ticker},{"$set": {"Country" : "Poland"}}, upsert=False,multi=False)
  
  myQuery = dumps(collection.find({"Ticker" : ticker}))
  
  print (myQuery)

#function for the delete request
@route('/delete', method='GET')
def delete():
  ticker = request.query.ticker

  collection.remove(ticker)

#Query for generating the report for the stocks
@route('/report',method='GET')
def report():
  ticker = request.query.ticker
  myQuery = dumps(collection.find({"Ticker" : ticker}, {"Profit Margin": 1,
                                                        "Institutional Ownership" : 1,
                                                       "EPS growth past 5 years" :1,
                                                       "Total Debt/Equity" : 1,
                                                       "Current Ratio" : 1}))
  print (myQuery)

#function for returning the industry request
@route('/industry',method='GET')
def read1():
  industry = request.query.industry
  myQuery = dumps(collection.find({"Industry" : industry}).limit(5))
  print (myQuery)

#makes the program run
run(host='localhost', port=8080, debug=True)