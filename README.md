## Deploy a batch job

```
./mvnw clean package -DskipTests=true
cf create-service cleardb spark batch-db
cf create-user-provided-service pushgateway -p '{"url":"https://your-pushgateway.example.com"}'
cf push
```

## Run a batch job

```
cf run-task demo-batch-micrometer "$(cf curl /v2/apps/$(cf app demo-batch-micrometer --guid) | jq -r .entity.detected_start_command) --spring.batch.job.enabled=true"
```