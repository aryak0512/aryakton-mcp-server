Claude config:

```json
{
  "mcpServers": {
    "aryak-mcp-server": {
      "command": "/Users/aryak/.sdkman/candidates/java/current/bin/java",
      "args": [
        "-Dspring.ai.mcp.server.stdio=true",
        "-jar",
        "/Users/aryak/Downloads/mcp-server/target/mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    },
    "aryakton-mcp-server": {
      "command": "npx",
      "args": [
        "-y",
        "mcp-remote",
        "http://localhost:8080/mcp"
      ]
    }
  }
}
```

Starting the inspector UI:

```shell
npx @modelcontextprotocol/inspector
```