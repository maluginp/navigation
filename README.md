# Navigation
Easy integration to presenters to work with calling and get result from activities

```kotlin
navigation.transit(DetailsTransition(1)) {
    if (it.isSuccess()) {
        view.showMessage("Completion success: ${it.data.type}")
    } else {
        view.showMessage("Completion cancelled")
    }
}
```

```kotlin
data class DetailsTransitionResult(val type: String)

class DetailsTransition(
    private val type: Int
) : ActivityTransition<DetailsTransitionResult>() {

    override fun create(context: Context): Intent {
        return DetailsActivity.getCallingIntent(context, type)
    }

    override fun map(intent: Intent?): DetailsTransitionResult {
        return DetailsTransitionResult(DetailsActivity.getResult(intent))
    }
}
```
