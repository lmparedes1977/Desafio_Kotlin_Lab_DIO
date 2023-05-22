package desafio.dio.kotlin

import kotlin.collections.mutableListOf

class Usuario(val name: String, val age: Int) {    
    
    val curriculo = mutableListOf<String>()

    fun inscrever(formacao: Formacao) {
        formacao.matricular(this)
        curriculo.add(formacao.name)
    }
}

data class ConteudoEducational(val name: String, val hourClass: Int)

data class Formacao(val name: String, var content: List<ConteudoEducational>) {

    val inscritos = mutableListOf<Usuario>()

    val carcaHoraria = totalHourClass(content)
        
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)        
    }
    
    fun totalHourClass(content: List<ConteudoEducational>): Int {
        var total = 0
        for (cont in content)
        total += cont.hourClass
        return total
    }
}

fun main() {

    val kotlinVariaveis = ConteudoEducational("Variaveis em Kotlin", 2)
    val kotlinFuncoes = ConteudoEducational("Funcoes em Kotlin", 2)
    val kotlinClasses = ConteudoEducational("Classes em Kotlin", 2)
    val kotlinGenerics = ConteudoEducational("Generics em Kotlin", 2)
    val dbRelacional = ConteudoEducational("Bancos de dados Relacionais", 3)
    val spring = ConteudoEducational("Kotlin no SpringBoot", 2)

    val formacaoKotlin = Formacao("Formação Kotlin DIO", listOf(kotlinFuncoes, kotlinClasses, kotlinVariaveis, kotlinGenerics, dbRelacional, spring))
    
    var aluno = Usuario("Leozão", 46)
    aluno.inscrever(formacaoKotlin)

    println(formacaoKotlin.content)
    println(aluno.curriculo)
    println(formacaoKotlin.carcaHoraria)

}