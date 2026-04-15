Write-Host "Starting Microservices..."

Start-Process powershell -ArgumentList "cd server-registry; mvn spring-boot:run"
Start-Process powershell -ArgumentList "cd user-service; mvn spring-boot:run"
Start-Process powershell -ArgumentList "cd product-service; mvn spring-boot:run"
Start-Process powershell -ArgumentList "cd order-service; mvn spring-boot:run"
Start-Process powershell -ArgumentList "cd api_gateway; mvn spring-boot:run"

Write-Host "All services started in separate windows"