import json
import boto3

client = boto3.client('codedeploy')
def handler(event, context):

    print("Entering PreTraffic Hook!")
    print(json.dumps(event))
    
    # Read the DeploymentId from the event payload.
    deploymentId = event['DeploymentId']
    print("deploymentId=" + deploymentId)

    # Read the LifecycleEventHookExecutionId from the event payload
    lifecycleEventHookExecutionId = event['LifecycleEventHookExecutionId']
    print("lifecycleEventHookExecutionId=" + lifecycleEventHookExecutionId)

    # Perform operations
    
    status = 'Succeeded'
    # Prepare the validation test results with the deploymentId and
    # the lifecycleEventHookExecutionId for AWS CodeDeploy.
    response = client.put_lifecycle_event_hook_execution_status(deploymentId=deploymentId, lifecycleEventHookExecutionId=lifecycleEventHookExecutionId, status=status)
    print("putLifecycleEventHookExecutionStatus done. executionStatus=[" + status + "]")
    return 'Validation test succeeded'
