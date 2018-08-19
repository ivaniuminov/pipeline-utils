package pro.javatar.pipeline.builder.model

import pro.javatar.pipeline.builder.Npm

class YamlConfig {

    String version

    Service service = new Service()

    Pipeline pipeline = new Pipeline()

    Maven maven = new Maven()

    Npm npm = new Npm()

    List<Docker> docker = new ArrayList<>()

    JenkinsTool jenkinsTool = new JenkinsTool()

    String getVersion() {
        return version
    }

    void setVersion(String version) {
        this.version = version
    }

    YamlConfig withVersion(String version) {
        this.version = version
        return this
    }

    Maven getMaven() {
        return maven
    }

    void setMaven(Maven maven) {
        this.maven = maven
    }

    YamlConfig withMaven(Maven maven) {
        this.maven = maven
        return this
    }

    Npm getNpm() {
        return npm
    }

    void setNpm(Npm npm) {
        this.npm = npm
    }

    YamlConfig withNpm(Npm npm) {
        this.npm = npm
        return this
    }

    List<Docker> getDocker() {
        return docker
    }

    void setDocker(List<Docker> docker) {
        this.docker = docker
    }

    YamlConfig withDocker(List<Docker> docker) {
        this.docker = docker
        return this
    }

    Service getService() {
        return service
    }

    void setService(Service service) {
        this.service = service
    }

    YamlConfig withService(Service service) {
        this.service = service
        return this
    }

    Pipeline getPipeline() {
        return pipeline
    }

    void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline
    }

    YamlConfig withPipeline(Pipeline pipeline) {
        this.pipeline = pipeline
        return this
    }

    JenkinsTool getJenkinsTool() {
        return jenkinsTool
    }

    void setJenkinsTool(JenkinsTool jenkinsTool) {
        this.jenkinsTool = jenkinsTool
    }

    YamlConfig withJenkinsTool(JenkinsTool jenkinsTool) {
        this.jenkinsTool = jenkinsTool
        return this
    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "version='" + version + '\'' +
                ", service=" + service +
                ", pipeline=" + pipeline +
                ", maven=" + maven +
                ", npm=" + npm +
                ", docker=" + docker +
                ", jenkinsTool=" + jenkinsTool +
                '}';
    }
}
