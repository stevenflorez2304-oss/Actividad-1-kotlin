enum class Rol {
    ADMIN,
    EDITOR,
    VISITANTE
}

interface Autenticable {
    fun autenticar(): Boolean
}

data class Usuario(
    val nombre: String,
    val correo: String,
    val rol: Rol
) : Autenticable {

    override fun autenticar(): Boolean {
        return correo.isNotEmpty()
    }
}

object GestorUsuarios {

    val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun validarRol(usuario: Usuario) {

        when (usuario.rol) {

            Rol.ADMIN -> {
                println("${usuario.nombre} es ADMIN y tiene todos los permisos.")
            }

            Rol.EDITOR -> {
                println("${usuario.nombre} es EDITOR y puede modificar contenido.")
            }

            Rol.VISITANTE -> {
                println("${usuario.nombre} es VISITANTE y solo puede consultar.")
            }
        }
    }
}

fun main() {

    val usuario1 = Usuario(
        "Steveen",
        "Steveen@gmail.com",
        Rol.ADMIN
    )

    val usuario2 = Usuario(
        "Juan",
        "Juam@gmail.com",
        Rol.EDITOR
    )

    val usuario3 = Usuario(
        "Santiago",
        "Santiago@gmail.com",
        Rol.VISITANTE
    )

    GestorUsuarios.agregarUsuario(usuario1)
    GestorUsuarios.agregarUsuario(usuario2)
    GestorUsuarios.agregarUsuario(usuario3)

    println("Usuarios registrados:")
    println()

    for (usuario in GestorUsuarios.usuarios) {

        println(usuario)

        if (usuario.autenticar()) {
            println("Usuario autenticado.")

            GestorUsuarios.validarRol(usuario)
        }

        println("-------------------------")
    }
}