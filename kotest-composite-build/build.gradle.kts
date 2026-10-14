tasks.register("check") { dependsOn(gradle.includedBuild("service-a").task(":check")) }
tasks.register("kotest") { dependsOn(gradle.includedBuild("service-a").task(":kotest")) }
