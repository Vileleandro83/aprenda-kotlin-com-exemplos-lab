
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }


data class Aluno(val nome: String)


data class ConteudoEducacional(val nome: String, val duracao: Int = 60)


data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    
    private val alunosMatriculados = mutableListOf<Aluno>()

    
    fun matricular(vararg alunos: Aluno) {
        alunosMatriculados.addAll(alunos)
        println("Aluno(s) matriculados ${alunos.joinToString(", ") { it.nome }} ")
    }

    
    fun exibirInformacoes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println("- ${it.nome} (${it.duracao} minutos)") }
        
    }
}

fun main() {
    
    val aluno1 = Aluno("Leandro")
    val aluno2 = Aluno("Isaac")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Desenvolvimento em Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    formacao.matricular(aluno1, aluno2)

    formacao.exibirInformacoes()
}