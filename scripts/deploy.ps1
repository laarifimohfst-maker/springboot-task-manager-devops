param(
    [Parameter(Mandatory = $true)]
    [string]$ImageTag
)

Set-Location (Join-Path $PSScriptRoot "..")

$env:IMAGE_TAG = $ImageTag

Write-Host "Version a deployer : $ImageTag"

docker compose pull app

if ($LASTEXITCODE -ne 0) {
    throw "Erreur pendant le téléchargement de l'image Docker"
}

docker compose up -d --no-build --no-deps --force-recreate app

if ($LASTEXITCODE -ne 0) {
    throw "Erreur pendant le deploiement"
}

docker compose ps