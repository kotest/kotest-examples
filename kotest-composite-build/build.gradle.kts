tasks.register("check") { dependsOn(gradle.includedBuild("service-a").task(":check")) }
