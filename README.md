
## Create a directory

```bash
mvn archetype:generate \
  -DgroupId=org.example.designAPen \
  -DartifactId=MachinCodingPractice \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

## Run
```bash
mvn compile && mvn package && java -cp target/classes org.example.inventory.App
```