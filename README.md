README

Projeto de exemplo utilizando o conjunto de ferramentas do Spring Cloud e Netflix OSS.

Esse projeto é composto por 4 microserviços, sendo 2 que fazem papel de infraestrutura, são eles:

EUREKA

Projeto Spring Cloud com o servidor Eureka do Netflix OSS, esse componente tem como responsabilidade atuar como Service Discover / Registry

GATEWAY 

Project Spring Cloud com o Zuul, esse componentes tem como responsabilidade manter a comunicação com o EUREKA e atualizar os microserviços registrados e disponiveis para utilização, ele atua como o GATEWAY (http://microservices.io/patterns/apigateway.html) para os outros microserviços.

RATING SERVICE

BOOKING SERVICE

Dependencias

	docker 
	kubectl
	minikube


Para desenvolvimento usamos o minikube (), para as imagens geradas pelo build não utilizaremos um Docker Registry, mas sim o daemon do docker com o seguintes comandos:

	$ minikube start 
	$ eval $(minikube docker-env)

Ingress Controller para permitir que os Services possam ser acessados foram do Cluster do k8s

	$ kubectl create -f http://central.maven.org/maven2/io/fabric8/devops/apps/exposecontroller/2.2.268/exposecontroller-2.2.268-kubernetes.yml

Fazer o build do projeto e seus dependentes, incluindo a geração das imagens Docker e também dos arquivos yaml e json para deploy no Kubernetes. (Utilizando o fabric8-maven-plugin)

	$ mvn clean install

Para fazer o deploy das imagens geradas pelo build dos serviços, rode o seguinte comando.
	
	$ mvn fabric8:deploy

Para visualizar o dashboard do Kubernetes rode o seguinte comando
	
	$ minikube dashboard

Para saber qual a url dos serviços que expões acesso externo direto, use os seguintes comandos:

	$ echo $(minikube service eureka-server --url)
 	$ echo $(minikube service gateway --url)

TODO 

- Adicionar comunicação entre RATING SERVICE e BOOK SERVICE usando o Spring Cloud Netflix Ribbon
- Adicionar no BOOK SERVICE a @Entity para BOOK e criar as classes necessárias para o JPA
- Adicionar imagem do PostgreSQL no pom.xml do parent do project para que o Fabric8 adicione nos arquivos de deploy automaticamente
- Adicionar Swagger para endpoint

ERROS CONHECIDOS

Algumas vezes o minikube não encontra as imagens sendo necessário reiniciar para salvar as configurações como --insecure-registry

	$ minikube delete

Autor

Roberto Santacroce Martins (rsmartins@brq.com)



