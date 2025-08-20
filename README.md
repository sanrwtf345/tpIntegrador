Registro de Libros Disponibles → Map<String, Libros>
HashMap es la mejor opcion para realizar búsquedas rápidas y evitar duplicados por ISBN.

Lista de Espera para Libros Prestados → Queue<Usuarios>
La reserva debe atenderse en orden de llegada por lo tanto una extructura queue es adecuada para esa situacion.

Historial de Préstamos por Usuario → List<Prestamos>
se utiliza arraylist ya que se necesita mantener el historial cronológico y permitir duplicados (un usuario puede pedir el mismo libro varias veces).

Catálogo de Libros por Categoría → Map<String, Set<Libro>>
Se requiere clasificar libros en múltiples categorías y evitar duplicados dentro de la misma, por lo tanto se usa HashMap para acceder rápido por categoría, y HashSet dentro para evitar duplicados.

Control de Usuarios Activos → Set<Usuario>
Solo deben existir usuarios únicos (ID único) por lo tanto HashSet es ideal porque garantiza unicidad y rapidez en la verificación.
