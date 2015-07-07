#ADSI

### The Prototype: <a href="http://23.23.207.102/analytics/index.html">http://23.23.207.102/analytics/index.html</a>

![alt tag](/images/ADSI_UI_Home_Page.bmp)

## Approach to Prototype Development

#### Leadership

The WTS team assigned [Mark Horwath] (/metadata/leadership/Mark Horwath_resume-brief.pdf), Principal Architect, as Project Leader and product owner of the prototype.  The duties of the leader were codified in a [Charter] (/metadata/leadership/ADSI_Leadership_Charter.pdf).

#### Multidisciplinary Team

Leadership created an initial prototype design. Guided by this design, a team was assembled with the expertise required to implement the prototype.
Please see the [Multidisciplinary Team Contents] (/metadata/team/Contents.md) for team allocations and resumes.

#### Modern Open-Source Technologies

The ADSI prototype is built on modern, open-source technologies.

See [Applied Technologies] (/metadata/modern-open-source-technologies/Technology_List.pdf) for a complete list.

#### Infrastructure-as-a-Service (IaaS)

The ADSI code is built on and deployed to the Amazon Web Services (AWS) cloud.

Please see [IaaS Artifacts Contents] (/metadata/infrastructure-as-a-service/Contents.md).

#### Unit Tests

ADSI uses JUnit. Unit tests were updated as design/implementation matured.

All unit tests can be found under the [Test Root Directory] (/src/test/java/com/wtsintegration/adsi)

CI drove execution of tests. Passing all tests was a criterion for tagging code as a viable release candidate.

#### Continuous Integration

The Jenkins CI server was used for ADSI builds/deployments.

A [Build Job] (/jenkins/ADSI/config.xml) monitors the code, automatically compiling and packaging all source code and executing all tests when changes to the GitHub repository are detected. Failure of this job results in email feedback to developers.

A [Deployment Job] (/jenkins/ADSI-docker/config.xml) shuts down existing Docker containers, re-generates container images, then starts new containers using them.

A [Publication Job] (/jenkins/ADSI-publish/config.xml) updates published Docker images in DockerHub.

Please see the [CI Artifacts Contents] (/metadata/continuous-integration/Contents.md) for more links.

#### Configuration Management (CM)

The team defined four CM requirements:

* Identifying functional units and linking them to code
* Controlling code changes 
* Tagging successful builds for release
* Deploying releases though automation

The team used JIRA for issue management. JIRA keys linked committed code changes to issues. Changes to the repository triggered automated builds and test execution. Failures in builds or tests precipitated email notifications to the team. Successful build/test cycles were tagged. API and UI Docker images were updated and deployed to Docker containers. 

The combination of all aspects of the CM strategy - repository (GitHub), source control (git), issue tracking and linking (JIRA), and CI and deployment (Jenkins)- resulted in the predictable delivery of value from inception through deployment.

Please see the [CM Artifacts Contents] (/metadata/configuration-management/Contents.md) for supporting links.

#### Continuous Monitoring

AWS CloudWatch was employed to monitor the state of ADSI security and resources.

Alarms were defined within CloudWatch to alert DevOps engineers if thresholds were met or exceeded on metrics of interest. In addition to those metrics provided out-of-the-box in CloudWatch, custom metrics were defined for common security scenarios.

See [Continuous Monitoring Artifacts Contents] (/metadata/continuous-monitoring/Contents.md) for more links.

#### Container Deployment

ADSI's deployment strategy included the definition/publication of two Docker images (UI and API). These images are inputs for containers that are scaled and managed independently.

The ADSI Dockerfiles can be found [Here] (/docker/) and the published images in [DockerHub] (https://registry.hub.docker.com/repos/wtsintegration/)

#### Iterative Approach

WTS applied an iterative approach to ADSI development. Three functional iterations (sprints) were preceded by an inception phase.

Inception: The team undertook preliminary design activities. Employing WTS space as a war-room, the team held a Protosketching session to postulate initial work patterns and personas. A preliminary user interface and product backlog were established. The Sprint 1 backlog defined a minimum viable product (MVP). The team also bootstrapped JIRA and Jenkins environments for MVP production.

Execution: A Sprint Planning ceremony yielded inception artifacts used for creation, estimation and self-assignment of stories. Team members developed code and unit tests. They maintained CM artifacts and contributed to evolving CI scripts to facilitate automated testing and deployment. 

Sprint 1 and all additional sprints resulted in the delivery of working software. Execution activities included feature-driven development of code through refactoring, TDD and API-first agnostic development. It also included support activities like DevOps promotion through CI, contribution to Agile artifacts and collaboration with the product owner.
 
At the end of each Sprint, the team conducted a demo and sprint review. The product owner and team determined deployment scenarios for the build. Leveraging the ongoing collaboration of the DevOps model, the team implemented the deployment scenario and fielded the application. 
Subsequent sprints were preceded by planning wherein captured metrics (burndown, velocity, carry-over/new backlog items) were analyzed and applied to future sprints.

For further detail see the links in the [Iterative Development Evidence Contents] (/metadata/iterative-approach/Contents.md).

#### Installation

Please see [ADSI Installation Instructions] (/metadata/install/Install.pdf).

#### Licensing 

All ADSI code, images, and other artifacts are openly available and free of charge.  Please see [The ADSI License] (/LICENSE).

All included third-party software and libraries are open source and free of charge.  Please see [ADSI Third-Party Dependencies] (/third-party/dependencies.html).

<Word Count = 743 (MS Word 2013)>
<Word Count = 745 (TextPad 5.4)>