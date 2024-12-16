# modular clean architecture
For large-scale Jetpack Compose projects in 2024, the latest architectural recommendations include using **modular clean architecture** combined with advanced tools like Hilt for dependency injection, Kotlin Coroutines for asynchronous tasks, and Retrofit for network calls. This approach helps to maintain scalability, improve maintainability, and enhance testability.

### Key Recommendations:
1. **Multi-Module Architecture**:
   - Split the project into modules such as `app`, `core`, `feature` (e.g., feature-specific modules), and `data`.
   - Example: A `core` module for shared utilities and libraries, and `feature` modules for specific functionalities like authentication or user profiles.

2. **MVVM Pattern**:
   - Combine with Jetpack libraries like Navigation to handle UI logic and ensure separation of concerns.
   - Use ViewModels to manage UI-related data, integrating seamlessly with Compose's state handling.

3. **Clean Architecture**:
   - Adopt layers: Domain (business logic), Data (repositories), and UI (Compose).
   - Repositories abstract data sources, making it easier to switch between APIs or databases.

4. **Dependency Injection with Hilt**:
   - Simplify module-level dependencies and scope ViewModels efficiently.

5. **Compose Best Practices**:
   - Use `LazyColumn` or `LazyGrid` for scalable lists/grids.
   - Optimize recompositions by following state management best practices.

6. **Navigation and State Management**:
   - Utilize Jetpack's Navigation component or a sealed class-based approach for type-safe navigation.
   - Consider `State`, `MutableState`, or `Flow` for reactive state management.

For examples of this architecture, repositories like:
- [Jetpack Compose Modularization with MVVM and Clean Architecture](https://github.com/kamrul3288/JetPackCompose-Modularization-MVVM-Clean-Architecture)【9】.
- [Multi-Module Architecture in Jetpack Compose](https://github.com/RalphTiama/Jetpack-Compose-Multimodule-Architecture-Build-variant-and-Flavors)【10】.

For detailed official guidelines, the [Jetpack Compose documentation](https://developer.android.com/jetpack/compose) provides insights on managing large projects effectively【8】.
