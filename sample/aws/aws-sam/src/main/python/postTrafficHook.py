import json
import boto3

client = boto3.client('codedeploy')
def handler(event, context):

    print("Entering PostTraffic Hook!")
    print(json.dumps(event))
    
    # Read the DeploymentId from the event payload.
    deploymentId = event['DeploymentId']
    print("deploymentId=" + deploymentId)

    # Read the LifecycleEventHookExecutionId from the event payload
    lifecycleEventHookExecutionId = event['LifecycleEventHookExecutionId']
    print("lifecycleEventHookExecutionId=" + lifecycleEventHookExecutionId)

    # Perform operations
    
    # Prepare the validation test results with the deploymentId and
    # the lifecycleEventHookExecutionId for AWS CodeDeploy.
    params = {
        'deploymentId': deploymentId,
        'lifecycleEventHookExecutionId': lifecycleEventHookExecutionId,
        'status': 'Succeeded' # status can be 'Succeeded' or 'Failed'
    }

    try :
      response = client.put_lifecycle_event_hook_execution_status(deploymentId=params['deploymentId'], lifecycleEventHookExecutionId=params['lifecycleEventHookExecutionId'], status=params['status'])
      print("putLifecycleEventHookExecutionStatus done. executionStatus=[" + params['status'] + "]")
      return 'Validation test succeeded'
    except Exception as err:
      # print("putLifecycleEventHookExecutionStatus ERROR: " + json.dumps(err))
      print(err)
      raise Error('Validation test failed')
