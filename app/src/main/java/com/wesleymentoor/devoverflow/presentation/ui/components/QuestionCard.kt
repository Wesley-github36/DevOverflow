package com.wesleymentoor.devoverflow.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wesleymentoor.devoverflow.R
import com.wesleymentoor.devoverflow.common.util.TagRow
import com.wesleymentoor.devoverflow.common.util.parseHtml
import com.wesleymentoor.devoverflow.data.remote.dto.Owner
import com.wesleymentoor.devoverflow.domain.model.Question
import com.wesleymentoor.devoverflow.presentation.ui.theme.DevOverflowTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuestionCard(
    question: Question,
    onItemClick: (Question) -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onItemClick(question) }

    ) {
        ConstraintLayout {
            val (textCaption, questionTitle, image, tags, textHtml) = createRefs()

            Text(
                text = "${question.owner.display_name} asked a question",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.constrainAs(textCaption) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(image.start)
                    width = Dimension.fillToConstraints
                },
                textAlign = TextAlign.Start
            )
            Text(
                text = question.title,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(questionTitle) {
                    top.linkTo(textCaption.bottom)
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(image.start)
                    width = Dimension.preferredWrapContent
                }
            )
            Image(
                painter = painterResource(id = R.drawable.re_zero),
                contentDescription = question.owner.user_id.toString(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .requiredSize(40.dp)
                    .constrainAs(image) {
                        top.linkTo(textCaption.top)
                        bottom.linkTo(questionTitle.bottom)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
            )
            TagRow(
                tags = question.tags,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(tags) {
                        top.linkTo(questionTitle.bottom)
                        start.linkTo(parent.start, margin = 8.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .constrainAs(textHtml) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(tags.bottom)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                },
                text = question.body.parseHtml()
            )

        }
    }
}



@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewHomeCard() {

    val owner = Owner(
        1L, 12, 12L, "Registered",
        "","Wesley Mentoor", "")
    val tags = mutableListOf("node.js", "javascript", "web-development", "java", "kotlin")

    val question = Question(
        tags = tags,
        owner = owner,
        is_answered = false,
        view_count = 12,
        score = 123,
        question_id = 12343432,
        link = "",
        title = "How to create a route controller with node.js and javascript",
        body = "<p>I am trying to add an element to the start of a linked list.\nBut it shows a segmentation fault.</p>\n<pre><code>include &lt;stdio.h&gt;\n#include &lt;stdlib.h&gt;\n\nstruct Node\n{\n  int data;\n  struct Node* next;\n  struct Node* prev;\n};\n\nvoid insertionAtHead(struct Node** head,int d){\n  if(head == NULL){\n    struct Node* n =(struct Node*)malloc(sizeof(struct Node));\n      *head = n;\n      (*head) -&gt; data = d;\n      (*head) -&gt; next = NULL;\n      (*head) -&gt; prev = NULL;\n      return;\n  }\n  struct Node* n = (struct Node*)malloc(sizeof(struct Node));\n  n-&gt;data = d;\n  (*head) -&gt; prev = n;\n  n-&gt;next = (*head);\n  n-&gt;prev = NULL;\n  *head = n;\n}\nvoid printLinkedList(struct Node * head){\n  while(head != NULL){\n    printf(&quot;%d -&gt; &quot;,head-&gt;data);\n    head = head -&gt; next;\n    \n  }\n  printf(&quot;\\n&quot;);\n}\nint main(){\n  struct Node* head = NULL;\n  insertionAtHead(&amp;head,6);\n printLinkedList(head);\n}\n</code></pre>\n<p>I think I have done everything correctly. can someone please guide me?</p>\n",
        answer_count = 12
    )

    DevOverflowTheme {
        QuestionCard(question = question, onItemClick = {})
    }
}

@Preview(name = "Light Mode")
@Composable
fun PreviewHomeCardDark() {

    val owner = Owner(
        1L, 12, 12L, "Registered",
        "","Wesley Mentoor", "")
    val tags = mutableListOf("node.js", "javascript", "web-development")

    val question = Question(
        tags = tags,
        owner = owner,
        is_answered = false,
        view_count = 12,
        score = 123,
        question_id = 12343432,
        link = "",
        title = "How to create a route",
        body = "<p>I am trying to add an element to the start of a linked list.\nBut it shows a segmentation fault.</p>\n<pre><code>include &lt;stdio.h&gt;\n#include &lt;stdlib.h&gt;\n\nstruct Node\n{\n  int data;\n  struct Node* next;\n  struct Node* prev;\n};\n\nvoid insertionAtHead(struct Node** head,int d){\n  if(head == NULL){\n    struct Node* n =(struct Node*)malloc(sizeof(struct Node));\n      *head = n;\n      (*head) -&gt; data = d;\n      (*head) -&gt; next = NULL;\n      (*head) -&gt; prev = NULL;\n      return;\n  }\n  struct Node* n = (struct Node*)malloc(sizeof(struct Node));\n  n-&gt;data = d;\n  (*head) -&gt; prev = n;\n  n-&gt;next = (*head);\n  n-&gt;prev = NULL;\n  *head = n;\n}\nvoid printLinkedList(struct Node * head){\n  while(head != NULL){\n    printf(&quot;%d -&gt; &quot;,head-&gt;data);\n    head = head -&gt; next;\n    \n  }\n  printf(&quot;\\n&quot;);\n}\nint main(){\n  struct Node* head = NULL;\n  insertionAtHead(&amp;head,6);\n printLinkedList(head);\n}\n</code></pre>\n<p>I think I have done everything correctly. can someone please guide me?</p>\n",
        answer_count = 12
    )

    DevOverflowTheme {
        QuestionCard(question = question) {

        }
    }
}
