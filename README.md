# Java Workshop
This repo is for the presenter. It contains the slides as markdown and the solutions.  
Copy all tasks and the generated pdf slides over to https://github.com/OpenValue-D/modern-java-workshop-tasks for the participants.

## Presentation
The slides are all in the `presentation` directory and start. The Workshop starts with `intro.md`.  
Then there are links to the following presentations and workshops. The examples usually go along with the presentation.

### Generate Slides

To view the slides `VSCode` with `Marp for VS Code` Plugin is recommended.

Generate HTML
```bash
marp intro.md
```

Generate PDF
```bash
marp intro.md --pdf
```

### Prerequisites

Install marpit CLI
```bash
npm install -g @marp-team/marp-cli
```