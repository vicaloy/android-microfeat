# 📱 Composing View Models with Micro-Features - Android Project

This project demonstrates breaking down ViewModels into smaller, self-contained Micro-Features using Jetpack Compose and advanced architectural patterns. It promotes UI composition and improves modularity, maintainability, and team collaboration.

## 🚀 Key Concepts

### Micro-Features:
- Small, self-contained UI components.
- Implements its own Unidirectional Data Flow (UDF).
- Host-agnostic and can be composed independently.

### UI Models vs. Jetpack ViewModels:
- UI Models: Platform-independent, easier to test, and react to UI events.
- ViewModels: Manage state and configuration changes but may introduce tight coupling.

## 🛠️ Technologies Used

- Kotlin: Main programming language.
- Jetpack Compose: For building modern, declarative UIs.
- ViewModels: For managing state and business logic.
- StateFlow: For reactive data flow handling.

## 🎯 How It Works

### Micro-Feature Architecture:
- Self-Contained Components:
- Each micro-feature has its own UI Model and Composable.
- Composable Factory APIs:
Factory methods create and manage UI Models.
- Host Integration:
Hosts act as containers that compose multiple micro-features. This allows dynamic content from different data sources to coexist on a single screen.

## 💡 Benefits of Micro-Features:
- Loose Coupling: Different features and domains can be developed independently.
- Reusability: UI components can be reused across multiple screens or contexts.
- Portability: Easy to plug-and-play micro-features into different hosts.


## 🔗 References

- https://speakerdeck.com/hakanbagci/composing-viewmodels-breaking-viewmodels-into-smaller-self-contained-ui-models-berlin-droidcon-2023?slide=34
- https://www.droidcon.com/2023/08/01/composing-viewmodels-breaking-viewmodels-into-smaller-self-contained-ui-models/
