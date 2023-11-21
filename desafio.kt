enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
	    if(!inscritos.contains(usuario)){
            println("Usuário ${usuario.nome} matriculado")
            inscritos.add(usuario)    
        } else {
            println("Usuário já matriculado")
        }
        
    }
    
    fun verInscritos(){
        println("\nAlunos matriculados em ${this.nome}:")
        for (i in inscritos){
            println("-${i.nome}")
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    //Criando Conteudos e Formações
    val javascript = ConteudoEducacional("Javascript", Nivel.BASICO)
    val html = ConteudoEducacional("Html", Nivel.BASICO)
    val css = ConteudoEducacional("CSS", Nivel.BASICO)
    val algoritmos = ConteudoEducacional("Algoritmos", Nivel.INTERMEDIARIO)
    val estruturas = ConteudoEducacional("Estruturas de dados", Nivel.INTERMEDIARIO)
    val docker = ConteudoEducacional("Docker", Nivel.AVANCADO)
    val escalabilidade = ConteudoEducacional("Escalabilidade", Nivel.AVANCADO)
    
    val frontend = Formacao("Basicos do Frontend", listOf(javascript, html, css))
    val algoritmosDados = Formacao("Algoritmos e Estruturas de dados", listOf(javascript, algoritmos, estruturas))
    val backendMaster = Formacao("Mestre do backend", listOf(docker, escalabilidade))
    
    //Criando Usuários
    val joao = Usuario("João")
    val pedro = Usuario("Pedro")
    val pedro2 = Usuario("Pedro")
    val davi = Usuario("Davi")
    val julia = Usuario("Julia")
    val maria = Usuario("Maria")
    //Matriculando
    frontend.matricular(joao)
    frontend.matricular(maria)
    algoritmosDados.matricular(joao)
    algoritmosDados.matricular(davi)
    algoritmosDados.matricular(julia)
    backendMaster.matricular(pedro)
    backendMaster.matricular(pedro2)
    backendMaster.matricular(pedro)
    
    frontend.verInscritos()
    algoritmosDados.verInscritos()
    backendMaster.verInscritos()
    
}
