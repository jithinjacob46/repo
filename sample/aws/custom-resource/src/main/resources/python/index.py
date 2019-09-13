import json
import cfnresponse
def handler(event, context):
  print(event)
  input = event['ResourceProperties']['Input']
  responseValue = input.swapcase()
  print(responseValue)
  responseData = {}
  responseData['Output'] = responseValue
  cfnresponse.send(event, context, cfnresponse.SUCCESS, responseData, "CustomResourcePhysicalID")