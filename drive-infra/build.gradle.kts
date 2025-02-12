tasks.named("bootJar").configure { enabled = false }
tasks.named("jar").configure { enabled = false }

tasks.named("resolveMainClassName").configure { enabled = false }