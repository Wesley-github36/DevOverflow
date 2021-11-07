package com.wesleymentoor.devoverflow.presentation.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

//@Composable
//fun Greeting(name: String) {
//    val html = "<p>Recently GitHub updated their <strong><strong>remote: Support for password authentication. which was removed on August 13, 2021</strong></strong> To use <strong>PAT(personal access token instead.)</strong> For Accessing the GitHub API.</p>\n<p>You can read on the blog post <a href=\"https://github.blog/2020-12-15-token-authentication-requirements-for-git-operations/\" rel=\"nofollow noreferrer\">here</a>.</p>\n<h2>Now to enable PAT</h2>\n<ul>\n<li>Login to your Github account.</li>\n<li>Follow <a href=\"https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token\" rel=\"nofollow noreferrer\">this</a> write up for next actions.</li>\n</ul>\n<p>Now to use the token on the command line, DO this:</p>\n<pre><code>$ git clone https://github.com/username/repo.git\nUsername: your_username\nPassword: your_token\n</code></pre>\n<p><strong>Note</strong> that your token has an expiry time and must be kept privately and used whenever you need to Authenticate on the CL.</p>\n<p><strong>HEADS UP</strong>\nIf your are cloning into a repo that is owned by an</p>\n<blockquote>\n<p>organisation</p>\n</blockquote>\n<ul>\n<li>Make sure your are <strong>member</strong> of that organisation</li>\n</ul>\n<blockquote>\n<p>Or if some personal repo,</p>\n</blockquote>\n<ul>\n<li>Make sure you have <strong>enabled</strong> the following</li>\n</ul>\n<p><strong>The organisation/personal</strong> will need to <em><strong>enable remote cloning and forking</strong></em> like so:</p>\n<ul>\n<li>Go to organisation settings:</li>\n</ul>\n<p><a href=\"https://i.stack.imgur.com/s5Jie.png\" rel=\"nofollow noreferrer\"><img src=\"https://i.stack.imgur.com/s5Jie.png\" alt=\"Settings page\" /></a></p>\n<ul>\n<li>Enable member priviledges:\n<a href=\"https://i.stack.imgur.com/KGYAO.png\" rel=\"nofollow noreferrer\"><img src=\"https://i.stack.imgur.com/KGYAO.png\" alt=\"Member Priviledges page\" /></a></li>\n</ul>\n"
//    val html2 = "<p>I am trying to add an element to the start of a linked list.<br>But it shows a segmentation fault.</p><br><pre><code>include &lt;stdio.h&gt;<br>#include &lt;stdlib.h&gt;\n\nstruct Node\n{\n  int data;\n  struct Node* next;\n  struct Node* prev;\n};\n\nvoid insertionAtHead(struct Node** head,int d){\n  if(head == NULL){\n    struct Node* n =(struct Node*)malloc(sizeof(struct Node));\n      *head = n;\n      (*head) -&gt; data = d;\n      (*head) -&gt; next = NULL;\n      (*head) -&gt; prev = NULL;\n      return;\n  }\n  struct Node* n = (struct Node*)malloc(sizeof(struct Node));\n  n-&gt;data = d;\n  (*head) -&gt; prev = n;\n  n-&gt;next = (*head);\n  n-&gt;prev = NULL;\n  *head = n;\n}\nvoid printLinkedList(struct Node * head){\n  while(head != NULL){\n    printf(&quot;%d -&gt; &quot;,head-&gt;data);\n    head = head -&gt; next;\n    \n  }\n  printf(&quot;\\n&quot;);\n}\nint main(){\n  struct Node* head = NULL;\n  insertionAtHead(&amp;head,6);\n printLinkedList(head);\n}\n</code></pre>\n<p>I think I have done everything correctly. can someone please guide me?</p>\n"
//
//    AndroidView (
//        modifier = Modifier.fillMaxWidth(),
//        factory = { context: Context ->
//            HtmlTextView(context).apply {
//                this.setHtml(html2)
//            }
//        }
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DevOverflowTheme {
//        Greeting("Android")
//    }
//}