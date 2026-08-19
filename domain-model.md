User Stories

Todo 

Todo (en enskild uppgift - bara data + sitt eget tillstånd)
- Attribut (int id, String description, boolean isComplete)
- Metoder (complete(), markIncomplete(), (eller en gemensam setstatus(boolean)))

TodoList (Samlingen - äger alla operationer på "listan")
- Attribut (int id, String description, boolean isComplete)
- Metoder, en lista med Todo-objekt, t.ex. List<Todo> todos
- Metoder, en per krav:
- addTodo(String description) -> "add tasks"
- getTodos() "see all tasks" returnerar hela listan
- completeTodo "hämtar rätt Todo och anropar dess complete()/markIncomplete()
- getCompleteTodos() -> filtrerar på isComplete == true
- getIncompleteTodos() -> filtrerar på isComplete == false
- findtodo(..) söker, kastar/returnerar "not found"- om inte den hittas alls
- removeTodo(..) tar bort en task ur listan
- getTodosAscending() / getTodosDescending() - sortering
