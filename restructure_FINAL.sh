#!/bin/bash
set -e
echo "🚀 НАЧИНАЕМ РЕСТРУКТУРИЗАЦИЮ"
mkdir -p composeApp/src/commonMain/kotlin/org/example/geoblinker/data
mkdir -p composeApp/src/commonMain/kotlin/org/example/geoblinker/domain
mkdir -p composeApp/src/commonMain/composeResources/drawable
mkdir -p composeApp/src/commonMain/composeResources/values
[ -d "data" ] && cp -r data/* composeApp/src/commonMain/kotlin/org/example/geoblinker/data/ && echo "✅ Data перенесена"
[ -d "domain" ] && cp -r domain/* composeApp/src/commonMain/kotlin/org/example/geoblinker/domain/ && echo "✅ Domain перенесен"
[ -f "App.kt" ] && mv App.kt composeApp/src/commonMain/kotlin/org/example/geoblinker/App.kt && echo "✅ App.kt перенесен"
cat <<EOT > composeApp/src/commonMain/composeResources/values/strings.xml
<resources>
    <string name="app_name">GeoBlinker</string>
</resources>
EOT
cat <<EOT > gradle.properties
org.gradle.jvmargs=-Xmx1536m -XX:MaxMetaspaceSize=512m
org.gradle.daemon=false
org.gradle.parallel=false
EOT
cat <<EOT > .gitignore
.gradle/
build/
**/build/
local.properties
.idea/
*.iml
