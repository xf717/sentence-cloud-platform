def git_url="https://gitee.com/qinsung-server-team/chaomaxs-cloud-platform.git"
def gitee_auth="7941c8e9-4591-436d-b9c5-6237327f8a12"
node {
    def mvnHome
    stage('拉取代码') {
    checkout([$class: 'GitSCM', branches: [[name: '*/develop']],
     extensions: [],
     userRemoteConfigs: [[credentialsId: "${gitee_auth}", url: "${git_url}"]]])

    }
     stage('构建代码') {
      echo "清理缓存，开始打包"
      sh 'mvn clean package -Pdev -Dmaven.test.skip=true'
    }
    stage('构建代码') {
      echo "构建完成之后，开始漫长的推送代码"
      sshPublisher(publishers: [sshPublisherDesc(configName: '39.102.85.38', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "bash /usr/local/chaomaxs/deploy.sh ${project_name} ${project_name_jar}", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/usr/local/chaomaxs/target', remoteDirectorySDF: false, removePrefix: '', sourceFiles: "${project_name}/target/${project_name_jar}.jar")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
    }
}