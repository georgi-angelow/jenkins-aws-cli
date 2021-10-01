def call(command) {
    try {
        docker.image("amazon/aws-cli:latest").inside("--entrypoint \"\" -e AWS_ACCESS_KEY_ID -e AWS_SECRET_ACCESS_KEY -e AWS_DEFAULT_REGION") {
            sh "aws ${command}"
        }
    } catch( ClassNotFoundException e ) {
        throw new Exception("Docker Pipeline plugin required")
    }
}
