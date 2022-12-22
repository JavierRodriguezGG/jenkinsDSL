job('segundo-job-DSL'){
 	description('Job DSL de ejemplo del curso de jenkins')
  	scm {
      git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
        node / gitConfigName ('javierrodriguezg')
        node / gitConfigEmail('example@example.com')
          }
      }
  	parameters{
    	stringParam('nombre', defaultValue = 'Javier', description = 'Parametro de cadena para el Job Booleano')
    	choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      	booleanParam('agente', false)
    }
  	triggers {
      	cron('H/7 * * * *')
  	}
  	steps {
    shell("bash jobscript.sh")
  	}
  	publishers{
  		mailer('javi.ja26@gmail.com', true, true)
    }
}
