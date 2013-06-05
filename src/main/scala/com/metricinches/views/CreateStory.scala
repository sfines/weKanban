package com.metricinches.views
//@TODO convert to a scalate template
object CreateStory {
  def apply(message:String = "") =
  <html>
    <head>
      <title>Create New Story</title>
      <link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" charset="utf-8" />
    </head>
    <body>
      <span class="message">{message}</span>
      <form action="/card/save" method="post" acccept-charset="utf-8">
        <fieldset>
          <legend>Create a new Story</legend>
          <div class="section">
            <label for="title">Title <span class="subtle">(describe the story)</span></label>
            <textarea rows="5" cols="30" name="title" id="title"></textarea>
          </div>
          <div class="section">
            <button type="submit">Save</button>
          </div>
        </fieldset>
      </form>
      <span class="linkLabel">
       <a href="/kanban/board">Go to Kanban Board</a>
      </span>
    </body>
  </html>
}
