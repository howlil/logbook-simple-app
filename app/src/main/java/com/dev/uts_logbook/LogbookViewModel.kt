package com.dev.uts_logbook
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.dev.uts_logbook.DataLogBook

class LogbookViewModel : ViewModel() {

    private val _logbookList = mutableStateListOf<DataLogBook>()
    val logbookList: List<DataLogBook> = _logbookList

    init {
        loadLogbookData()
    }

    private fun loadLogbookData() {
        val json = """
      [
          {
            "id": 1,
            "title": "Daily Meeting",
            "description": "Discussed project updates including recent developments in the backend service architecture and frontend UI enhancements. Specific focus was given to the performance improvements that are planned for the next sprint and identifying blockers related to third-party API integration.",
            "status": "Tidak Terverifikasi",
            "date": "2023-10-01"
          },
          {
            "id": 2,
            "title": "Code Review",
            "description": "Reviewed Pull Request #42, which included refactoring of the authentication module and resolving issues related to session timeouts. The review focused on ensuring that security protocols are being followed and performance benchmarks are maintained.",
            "status": "Terverifikasi",
            "date": "2023-10-02"
          },
          {
            "id": 3,
            "title": "Client Presentation Preparation",
            "description": "Prepared the presentation for the upcoming client meeting. Focused on highlighting key project achievements, including the completion of the MVP phase, integration of client-requested features, and a demonstration of the working prototype. Feedback from previous presentations was incorporated into the new slides.",
            "status": "Menunggu Verifikasi",
            "date": "2023-10-03"
          },
          {
            "id": 4,
            "title": "Design Review",
            "description": "Conducted a design review session with the UX/UI team to ensure the new feature designs align with the overall product vision. Discussions revolved around user experience improvements for mobile responsiveness, color scheme updates for better accessibility, and implementing user feedback received from beta testers.",
            "status": "Terverifikasi",
            "date": "2023-10-04"
          },
          {
            "id": 5,
            "title": "Sprint Planning",
            "description": "Participated in sprint planning for the next development cycle. Key tasks were prioritized based on client feedback, and team members were assigned specific roles for each user story. Discussion also covered upcoming releases and deadlines, and potential risks were identified early in the process.",
            "status": "Terverifikasi",
            "date": "2023-10-05"
          },
          {
            "id": 6,
            "title": "Database Optimization",
            "description": "Worked on optimizing database queries for the analytics dashboard. This involved identifying slow-running queries and creating more efficient SQL statements. Indexing strategies were discussed, and the impact on overall database performance was analyzed. The goal is to reduce data retrieval time by 40%.",
            "status": "Menunggu Verifikasi",
            "date": "2023-10-06"
          },
          {
            "id": 7,
            "title": "Bug Triage Meeting",
            "description": "Held a bug triage meeting to address critical issues that have been reported by the QA team. The focus was on high-priority bugs that impact core functionality. Tasks were assigned to developers, and deadlines were set to ensure the issues are resolved before the next release.",
            "status": "Terverifikasi",
            "date": "2023-10-07"
          },
          {
            "id": 8,
            "title": "Feature Development: Notifications",
            "description": "Started working on the notification feature for the user dashboard. This feature will allow users to receive real-time updates on their tasks and projects. The implementation will include both push notifications and in-app alerts. Initial discussions were held with the product owner to define the requirements.",
            "status": "Terverifikasi",
            "date": "2023-10-08"
          },
          {
            "id": 9,
            "title": "User Feedback Session",
            "description": "Conducted a user feedback session with key stakeholders to gather insights on the newly launched feature. Several usability issues were identified, especially around the user journey for first-time users. Recommendations for improvements were documented for the next sprint.",
            "status": "Terverifikasi",
            "date": "2023-10-09"
          },
          {
            "id": 10,
            "title": "System Security Audit",
            "description": "Performed a system security audit to ensure compliance with the latest security protocols. This included checking for vulnerabilities in the authentication flow, ensuring that encryption standards are up to date, and reviewing access control policies. Recommendations were made for improving password management practices.",
            "status": "Menunggu Verifikasi",
            "date": "2023-10-10"
          }
        ]

        """

        val gson = Gson()
        val logbookType = object : TypeToken<List<DataLogBook>>() {}.type
        val logbooks: List<DataLogBook> = gson.fromJson(json, logbookType)

        _logbookList.addAll(logbooks)
    }
}
