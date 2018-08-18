package pro.javatar.pipeline.builder.converter

import pro.javatar.pipeline.builder.model.Docker
import pro.javatar.pipeline.builder.model.Maven
import pro.javatar.pipeline.builder.Npm
import pro.javatar.pipeline.builder.model.YamlFile
import static pro.javatar.pipeline.service.PipelineDslHolder.dsl

class YamlConverter {

    YamlFile toYamlModel(def yml) {
        YamlFile model = new YamlFile()
        model.setNpm(retrieveNpm(yml))
        model.setMaven(retrieveMaven(yml))
        model.setDocker(retrieveDockerList(yml))
        return model
    }

    List<Docker> retrieveDockerList(def yml) {
        def docker = yml.docker
        dsl.echo "populateDocker: docker: ${docker}"
        List<Docker> dockers = new ArrayList<>()
        docker.each{dockerItem -> dockers.add(retrieveDocker(dockerItem))}
        return dockers
    }

    Docker retrieveDocker(def dockerItem) {
        dsl.echo "retrieveDocker: dockerItem: ${dockerItem}"
        Docker docker = new Docker()
                .withCredentialsId(dockerItem.credentialsId)
                .withRegistry(dockerItem.registry)
                .withEnv(retrieveEnvList(dockerItem.env))
        return docker
    }

    List<String> retrieveEnvList(def env) {
        dsl.echo "retrieveEnvList: env: ${env}"
        List<String> envList = new ArrayList<>()
        env.each{envItem -> envList.add(envItem)}
        return envList
    }

    Maven retrieveMaven(def yml) {
        def maven = yml.maven
        dsl.echo "populateMaven: maven: ${maven}"
        return new Maven()
                .withRepositoryId(maven.repository.id)
                .withRepositoryUrl(maven.repository.url)
                .withParams(maven.params)
    }

    Npm retrieveNpm(def yml) {
        def npm = yml.npm
        dsl.echo "populateNpm: npm: ${npm}"
        return new Npm()
                .withNpmType(npm.type)
                .withNpmVersion(npm.version)
                .withDistributionFolder(npm.distributionFolder)
                .withModuleRepository(npm.moduleRepository)
    }

}
