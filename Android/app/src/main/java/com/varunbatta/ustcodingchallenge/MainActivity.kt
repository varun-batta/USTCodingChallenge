package com.varunbatta.ustcodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView

class MainActivity : AppCompatActivity() {

    var cvAdapter: ExpandableListAdapter? = null
    var cvSections: ExpandableListView? = null
    var cvSectionHeader: List<String>? = null
    var cvSectionDetails: HashMap<String, List<String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("CV")

        // Handle populating the list view
        cvSections = findViewById(R.id.cv_sections)
        prepareCVData()
        cvAdapter = ExpandableListAdapter(applicationContext, cvSectionHeader as List<String>, cvSectionDetails as HashMap<String, List<String>>)
        cvSections?.setAdapter(cvAdapter)
    }

    fun prepareCVData() {
        cvSectionHeader = listOf(
            "Personal Details",
            "Objective & Summary",
            "Technical Skills",
            "Work Experiences",
            "Education",
            "Awards & Scholarships",
            "Other Activities",
            "Languages"
        )

        // Personal Details Section
        var personalDetails = listOf(
            "Name: \tVarun Batta",
            "Job Title: \tSoftware Engineer",
            "Location: \tToronto, Ontario",
            "Address: \tUnit 2805, 15 Iceboat Terr, Toronto, ON, M5V 4A5",
            "Phone: \t519 591 0928",
            "Email: \tvarunbatta@hotmail.com"
        )

        // Objective & Summary Section
        var objectiveAndSummary = listOf(
            "To work with a team of developers and gain experience developing software/hardware for new products.",
            " - Proficient in frontend app development",
            "\t - Developed a multi-level, GUI game on Android and iOS",
            " - In depth understanding of Object-Oriented pgoramming principles",
            " - Experience in handling multithreaded programming for atomicity",
            " - Demonstrated ability to grasp new ideas and concepts quickly",
            " - Excellent communication, analytical, and organizational skills",
            " - Work well within a team environment",
            " - Self-motivated and handle responsibility well"
        )

        // Technical Skills
        var technicalSkills = listOf(
            "Computer Languages: \n" +
                    "\tC#.Net\n" +
                    "\tJava\n" +
                    "\tPython\n" +
                    "\tC\n" +
                    "\tC++\n" +
                    "\tARM Assembly\n" +
                    "\tVHDL\n" +
                    "\tSQL\n" +
                    "\tSwift\n" +
                    "\tObjective-C\n" +
                    "\tGolang\n" +
                    "\tKotlin",
            "Internet Languages: \n" +
                    "\tHTML\n" +
                    "\tJavascript\n" +
                    "\tPHP",
            "Integrated Development Environments: \n" +
                    "\tEclipse\n" +
                    "\tNotepad++\n" +
                    "\tIntelliJ IDEA\n" +
                    "\tAndroid Studio\n" +
                    "\tXCode\n" +
                    "\tVisual Studio",
            "Application Operating Systems: \n" +
                    "\tAndroid\n" +
                    "\tiOS\n" +
                    "\tRedux/React",
            "Computer Operating Systems: \n" +
                    "\tWindows XP/7/8/10\n" +
                    "\tUbuntu\n" +
                    "\tMac OS",
            "Communication Protocols: \n" +
                    "\tNear Field Communication\n" +
                    "\tISO-14443 A and B",
            "Continuous Integration Interfaces: \n" +
                    "\tJenkins",
            "Version Control Systems: \n" +
                    "\tMercurial\n" +
                    "\tGitHub\n" +
                    "\tBitbucket",
            "Testing Frameworks: \n" +
                    "\tPytest"
        )

        // Work Experience
        var workExperience = listOf(
            "ChefHero Inc.\n" +
                    "\tJune 2018 - October 2019\n" +
                    "\tSoftware Engineer, Toronto, Ontario\n" +
                    "\tDeveloping the ChefHero production application across all front‐end platforms\n" +
                    "\t\t - Worked with Objective‐C for iOS, Java for Android, and JavaScript using React and Redux for WebApp\n" +
                    "\t\t - Experience with many third‐party APIs for email services, user interaction, analytics and more\n" +
                    "\t\t - Took ownership of projects to understand all requirements and best way to implement",
            "ChefHero Inc.\n" +
                    "\tSeptember 2017 – December 2017\n" +
                    "\tiOS Developer Intern, Toronto, Ontario\n" +
                    "\tDeveloping the ChefHero production application for iOS\n" +
                    "\t\t - Modified end‐user app UI/UX for navigation and shopping experience\n" +
                    "\t\t - Added time zone functionality to backend to allow expansion\n" +
                    "\t\t - Redefined how to report problems by creating a complete flow of steps for dispute",
            "TD Canada Trust\n" +
                    "\tFebruary 2017 – April 2017\n" +
                    "\tTest Developer, Cloud Software Dev‐Ops Team, Waterloo, Ontario\n" +
                    "\tWorking full‐time, developed unit tests for cloud software\n" +
                    "\t\t - Brought test coverage up from 10% to 70%\n" +
                    "\t\t - Worked with and developed custom mocking algorithms for atomicity\n" +
                    "\t\t - Used various third‐party libraries to better present the coverage and improvements that can be made to the tests",
            "Cisco Systems\n" +
                    "\tInc. January 2016 – April 2016\n" +
                    "\tSoftware Developer Co‐Op, Core Software Group, Ottawa, Ontario\n" +
                    "\tDeveloping scripts for automation of testing and using Continuous Integration tools, such as Jenkins\n" +
                    "\t\t - Introduced Jenkins for Continuous Integration purposes\n" +
                    "\t\t - Automated unit testing, integration testing, and sanity testing\n" +
                    "\t\t - Provided documentation for how to add this continuous integration to additional repositories",
            "Nucleus Software Exports Ltd.\n" +
                    "\tMay 2015 – August 2015\n" +
                    "\tSoftware Developer Intern, Financial Inclusion, Nucleus Software Exports Ltd., Noida, India\n" +
                    "\tDeveloping API for server management and Near Field Communication with MiFare Cards\n" +
                    "\t\t - Developed CMAC and CRC32 algorithms for NFC communication protocols required to transfer money and check balance on your MiFare card (used for public transportation)\n" +
                    "\t\t - Also worked with the NFC protocols required for inter‐device financial communication\n" +
                    "\t\t - Created automated scripts to test and manage version control of servers",
            "SMART Technologies\n" +
                    "\tSeptember 2014 – December 2014\n" +
                    "\tSoftware Developer Co‐Op, Identity Services, SMART Technologies, Calgary, Alberta\n" +
                    "\tWorking full‐time as a software developer, developing back‐end subscription and user identity tools\n" +
                    "\t\t - Managed multi‐lingual display of all services using the i18n library\n" +
                    "\t\t - Developed a reset option for a syncing feature ensuring complete sync"
        )

        // Education
        var education = listOf(
            "Apr 2013 Apr 2018\n" +
                    "University of Waterloo, Waterloo, Ontario\n" +
                    "Candidate for Bachelor of Applied Science, Honors, Computer Engineering, Co‐operative Education, Entrepreneurship Option\n" +
                    "\t - Spent one academic term at École Polytechnique Fédérale de Lausanne, Switzerland as Exchange Student\n" +
                    "\t - Key Courses on Exchange: Machine Learning, Concurrent Algorithms, Cryptography and Security, Digital Signal and Image Processing",
            "Sept 2008 June 2012\n" +
                    "American Embassy School, New Delhi, India\n" +
                    "\t - Graduated top of IB Diploma class\n" +
                    "\t - Designed and authored client oriented program for managing tutoring service"
        )

        // Awards & Scholarships
        var awardsAndScholarships = listOf(
            "University of Waterloo\n" +
                    "\t - University of Waterloo President’s Scholarship of Distinction (3.8+ GPA Required) – April 2013\n" +
                    "\t - Faculty of Engineering Entrance Scholarship",
            "American Embassy School\n" +
                    "\t - Salutatorian; Graduating Class of 2012\n" +
                    "\t - Outstanding Student Award for Computer Science, Mathematics, and Physics"
        )

        // Other Activities
        var otherActivities = listOf(
            " - Elected as president of Computer Honor Society, American Embassy School, New Delhi, India",
            " - Inducted as member of National Honor Society, American Embassy School, New Delhi, India",
            " - Interscholastic Association of SE Asian Schools Model United Nations in Manila, Philippines",
            " - Founded the Broadcasting Club in High School",
            " - Represented school in Mathematics Competition in Kathmandu and Dhaka",
            " - Represented school in the International AMIS Music Competition, Beijing, China",
            " - Member of Varsity Badminton Team"
        )

        // Languages
        var languages = listOf(
            " - Verbal and written fluency in English",
            " - Verbal and written fluency in French",
            " - Verbal fluency in Hindi"
        )

        // Populating section children now
        var sectionDetails = listOf(
            personalDetails,
            objectiveAndSummary,
            technicalSkills,
            workExperience,
            education,
            awardsAndScholarships,
            otherActivities,
            languages
        )

        cvSectionDetails = hashMapOf()
        for (i in cvSectionHeader!!.indices) {
            cvSectionDetails!!.put(cvSectionHeader!![i], sectionDetails[i])
        }
    }
}
