package com.metricinches.views

import com.metricinches.models._

//TODO convert to a scalate template
object KanbanBoard {
  def apply()=
  <html>
    <head>{header}</head>
    <body>
      <h2 class="header">Simple Kanban Board</h2>

      <span id="message" class="message clearFloat"> </span>
      <br />

      <a href="/card/create">[Add New Story]</a>

      <div class="phase" id="readyPhase">
        <h3 class="message" title="Stories ready for development, limit set to 3">Ready [3]</h3>
        {stories("ready")}
      </div>

      <div class="phase" id="devPhase">
        <h3 class="message" title="Stories in progress, limit set to 2">Dev [2]</h3>
        {stories("dev")}
      </div>

      <div class="phase" id="testPhase">
        <h3 class="message" title="Stories that are tested, limit set to 2">Test [3]</h3>
        {stories("test")}
      </div>

      <div class="phase" id="deployPhase">
        <h3 class="message" title="Stories ready for deployment">Deploy</h3>
        {stories("deploy")}
      </div>

    </body>
  </html>


  private def header =
    <head>
      <meta charset="UTF-" />
      <title>weKanban: A Simple Kanban Board</title>

      <script type="text/javascript" src="/js/jquery-1.4.2.js" ></script>
      <script type="text/javascript" src="/js/jquery.ui.core.js"></script>
      <script type="text/javascript" src="/js/jquery.ui.widget.js"></script>
      <script type="text/javascript" src="/js/jquery.ui.mouse.js"></script>
      <script type="text/javascript" src="/js/jquery.ui.draggable.js"></script>
      <script type="text/javascript" src="/js/jquery.ui.droppable.js"></script>
      <script type="text/javascript" src="/js/main.js"></script>
      <script type="text/javascript">
        init();
      </script>

      <link type="text/css" href="/css/main.css" rel="stylesheet" media="screen" />
    </head>



  private def stories(phase:String) =
    for(story <- Story.findAllByPhase(phase)) yield
      <div id={story.number} class="story">
        <fieldset>
          <legend>{story.number}</legend>
          <div class="section">
            <label>{story.title}</label>
          </div>
        </fieldset>
      </div>
}
