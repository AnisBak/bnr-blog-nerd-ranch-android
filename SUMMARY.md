#Summary 

- The recyclerView now displays the title, author, summary, and publish date
- The UI is basic but we can differentiate the different posts
- The app don't fetch anything from the server over configuration change, the UI state
is persisted in the ViewModels
- Archibald's _massive_ blog post doesn't take a long time to download from the server.
the user experience is improved for large posts. the way I did it is that I fetched all the posts at the creation
of the first activity and passed a Post object to the second activity each time the user clicks.
- The networking code is removed from the UI code now and placed in DI module. And only
one instance of the blog service is used by the app
- Given more time, I would have written some unit tests and UI tests and change keep one activity with two fragments and
one viewModel scoped to one activity to persist UI.