import com.example.ges_sports.models.User

object LoginRepository { //Singleton

    private val usuarios = listOf(
        User(1, "Ana López", "ana@correo.com", "1234", "admin"),
        User(2, "Luis Gómez", "luis@correo.com", "abcd", "usuario"),
        User(3, "María Pérez", "maria@correo.com", "pass1", "usuario"),
        User(4, "Carlos Ruiz", "carlos@correo.com", "pass2", "editor"),
        User(5, "Laura Díaz", "laura@correo.com", "laura123", "usuario"),
        User(6, "Javier Torres", "javier@correo.com", "javi2025", "admin"),
        User(7, "Sofía Sánchez", "sofia@correo.com", "sofia!", "usuario"),
        User(8, "Miguel Fernández", "miguel@correo.com", "clave", "editor"),
        User(9, "Elena Ramírez", "elena@correo.com", "hola123", "usuario"),
        User(10, "Pedro Martín", "pedro@correo.com", "pedro321", "usuario")
    )

    /*fun autenticar(email: String, password: String): User? {
        return usuarios.find { it.email == email && it.password == password }
    }*/

    fun obtenerUsuarios(): List<User> = usuarios
}