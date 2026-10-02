/* =========================================================
   SMART DECISION ASSISTANT
   MAIN JAVASCRIPT FILE
   ========================================================= */


/* =========================================================
   PAGE DETECTION
   ========================================================= */

const currentPage = window.location.pathname.toLowerCase();


/* =========================================================
   SMART ASSISTANT BUTTON
   ========================================================= */

const assistantButton = document.querySelector("#assistantButton");

if (assistantButton) {

    assistantButton.addEventListener("click", function () {

        const isHomePage =
            currentPage.includes("index.html") ||
            currentPage.endsWith("/");

        if (isHomePage) {

            const searchInput =
                document.querySelector("#searchInput");

            if (searchInput) {

                searchInput.focus();

                searchInput.placeholder =
                    "Try: laptop, mobile, career or travel";
            }

        } else {

            window.location.href = "index.html";

        }

    });

}


/* =========================================================
   HOME PAGE SEARCH
   ========================================================= */

const searchButton =
    document.querySelector("#searchButton");

const searchInput =
    document.querySelector("#searchInput");

const searchResult =
    document.querySelector("#searchResult");


if (searchButton && searchInput) {

    searchButton.addEventListener(
        "click",
        performSearch
    );


    searchInput.addEventListener(
        "keydown",
        function (event) {

            if (event.key === "Enter") {

                performSearch();

            }

        }
    );

}


/* =========================================================
   SEARCH FUNCTION
   ========================================================= */

function performSearch() {

    const value =
        searchInput.value
            .trim()
            .toLowerCase();


    /* Empty search */

    if (value === "") {

        showSearchMessage(
            "Please enter something to search."
        );

        return;

    }


    /* =====================================================
       LAPTOP
       ===================================================== */

    if (

        value.includes("laptop") ||
        value.includes("computer") ||
        value.includes("notebook") ||
        value === "pc" ||
        value.includes("dell") ||
        value.includes("hp") ||
        value.includes("lenovo") ||
        value.includes("asus") ||
        value.includes("macbook") ||
        value.includes("gaming laptop")

    ) {

        showSearchMessage(
            "Laptop selected. Opening Laptop Decision Assistant..."
        );

        setTimeout(function () {

            window.location.href = "laptop.html";

        }, 700);

        return;

    }


    /* =====================================================
       MOBILE
       ===================================================== */

    if (

        value.includes("mobile") ||
        value.includes("phone") ||
        value.includes("smartphone") ||
        value.includes("android") ||
        value.includes("iphone") ||
        value.includes("samsung") ||
        value.includes("redmi") ||
        value.includes("oneplus") ||
        value.includes("pixel") ||
        value.includes("camera phone")

    ) {

        showSearchMessage(
            "Mobile selected. Opening Mobile Decision Assistant..."
        );

        setTimeout(function () {

            window.location.href = "mobile.html";

        }, 700);

        return;

    }


    /* =====================================================
       CAREER
       ===================================================== */

    if (

        value.includes("career") ||
        value.includes("job") ||
        value.includes("developer") ||
        value.includes("software") ||
        value.includes("java") ||
        value.includes("programming") ||
        value.includes("coding") ||
        value.includes("it job") ||
        value.includes("web developer") ||
        value.includes("career path")

    ) {

        showSearchMessage(
            "Career selected. Opening Career Decision Assistant..."
        );

        setTimeout(function () {

            window.location.href = "career.html";

        }, 700);

        return;

    }


    /* =====================================================
       TRAVEL
       ===================================================== */

    if (

        value.includes("travel") ||
        value.includes("trip") ||
        value.includes("tour") ||
        value.includes("destination") ||
        value.includes("vacation") ||
        value.includes("holiday") ||
        value.includes("goa") ||
        value.includes("manali") ||
        value.includes("ooty") ||
        value.includes("mysore") ||
        value.includes("rishikesh")

    ) {

        showSearchMessage(
            "Travel selected. Opening Travel Decision Assistant..."
        );

        setTimeout(function () {

            window.location.href = "travel.html";

        }, 700);

        return;

    }


    /* =====================================================
       NO RESULT
       ===================================================== */

    showSearchMessage(
        "No matching category found. Try laptop, mobile, career or travel."
    );

}


/* =========================================================
   SEARCH MESSAGE
   ========================================================= */

function showSearchMessage(message) {

    if (!searchResult) {
        return;
    }


    searchResult.style.display = "block";

    searchResult.textContent = message;

}


/* =========================================================
   RECOMMENDATION BUTTON
   ========================================================= */

const recommendButton =
    document.querySelector(".recommend-btn");


if (recommendButton) {

    recommendButton.addEventListener(
        "click",
        handleRecommendation
    );

}


/* =========================================================
   RECOMMENDATION CONTROLLER
   ========================================================= */

function handleRecommendation() {

    if (currentPage.includes("laptop")) {

        recommendLaptop();

    }

    else if (currentPage.includes("mobile")) {

        recommendMobile();

    }

    else if (currentPage.includes("career")) {

        recommendCareer();

    }

    else if (currentPage.includes("travel")) {

        recommendTravel();

    }

}


/* =========================================================
   LAPTOP RECOMMENDATION
   ========================================================= */

function recommendLaptop() {

    const budget =
        Number(
            document.querySelector("#budget")?.value
        );

    const ram =
        Number(
            document.querySelector("#ram")?.value
        );

    const performance =
        Number(
            document.querySelector("#performance")?.value
        );


    if (!budget || !ram || !performance) {

        showFormMessage(
            "Please enter budget, RAM and performance."
        );

        return;

    }


    const laptops = [

        {
            name: "Dell Inspiron",
            price: 45000,
            ram: 8,
            performance: 6
        },

        {
            name: "Lenovo IdeaPad",
            price: 50000,
            ram: 8,
            performance: 7
        },

        {
            name: "HP Pavilion",
            price: 60000,
            ram: 16,
            performance: 8
        },

        {
            name: "ASUS VivoBook",
            price: 70000,
            ram: 16,
            performance: 8
        },

        {
            name: "Apple MacBook",
            price: 90000,
            ram: 32,
            performance: 9
        }

    ];


    let bestLaptop = null;

    let bestScore = -1;


    laptops.forEach(function (laptop) {

        if (

            laptop.price <= budget &&
            laptop.ram >= ram &&
            laptop.performance >= performance

        ) {

            const score =
                laptop.ram +
                laptop.performance;


            if (score > bestScore) {

                bestScore = score;

                bestLaptop = laptop;

            }

        }

    });


    if (!bestLaptop) {

        showResultMessage(
            "No laptop found within your budget and requirements."
        );

        return;

    }


    const details =
        document.querySelector(".result-details");


    if (!details) {
        return;
    }


    details.innerHTML = `

        <p>
            <strong>Laptop Name:</strong>
            ${bestLaptop.name}
        </p>

        <p>
            <strong>Price:</strong>
            ₹${bestLaptop.price.toLocaleString("en-IN")}
        </p>

        <p>
            <strong>RAM:</strong>
            ${bestLaptop.ram} GB
        </p>

        <p>
            <strong>Performance:</strong>
            ${getLevel(bestLaptop.performance)}
        </p>

        <p>
            <strong>Recommendation Score:</strong>
            ${bestScore}
        </p>

    `;


    updateResultHeading(
        "Recommended Laptop"
    );

}


/* =========================================================
   MOBILE RECOMMENDATION
   ========================================================= */

function recommendMobile() {

    const budget =
        Number(
            document.querySelector("#budget")?.value
        );

    const camera =
        Number(
            document.querySelector("#camera")?.value
        );

    const battery =
        Number(
            document.querySelector("#battery")?.value
        );

    const performance =
        Number(
            document.querySelector("#performance")?.value
        );


    if (
        !budget ||
        !camera ||
        !battery ||
        !performance
    ) {

        showFormMessage(
            "Please enter budget, camera, battery and performance."
        );

        return;

    }


    const mobiles = [

        {
            name: "Samsung Galaxy M Series",
            price: 15000,
            camera: 7,
            battery: 8,
            performance: 7
        },

        {
            name: "Redmi Note Series",
            price: 18000,
            camera: 8,
            battery: 8,
            performance: 8
        },

        {
            name: "OnePlus Nord",
            price: 25000,
            camera: 8,
            battery: 8,
            performance: 9
        },

        {
            name: "Google Pixel",
            price: 40000,
            camera: 9,
            battery: 7,
            performance: 8
        },

        {
            name: "iPhone",
            price: 60000,
            camera: 9,
            battery: 8,
            performance: 9
        }

    ];


    let bestMobile = null;

    let bestScore = -1;


    mobiles.forEach(function (mobile) {

        if (

            mobile.price <= budget &&
            mobile.camera >= camera &&
            mobile.battery >= battery &&
            mobile.performance >= performance

        ) {

            const score =
                mobile.camera +
                mobile.battery +
                mobile.performance;


            if (score > bestScore) {

                bestScore = score;

                bestMobile = mobile;

            }

        }

    });


    if (!bestMobile) {

        showResultMessage(
            "No mobile found within your budget and requirements."
        );

        return;

    }


    const details =
        document.querySelector(".result-details");


    if (!details) {
        return;
    }


    details.innerHTML = `

        <p>
            <strong>Mobile:</strong>
            ${bestMobile.name}
        </p>

        <p>
            <strong>Price:</strong>
            ₹${bestMobile.price.toLocaleString("en-IN")}
        </p>

        <p>
            <strong>Camera:</strong>
            ${getLevel(bestMobile.camera)}
        </p>

        <p>
            <strong>Battery:</strong>
            ${getLevel(bestMobile.battery)}
        </p>

        <p>
            <strong>Performance:</strong>
            ${getLevel(bestMobile.performance)}
        </p>

        <p>
            <strong>Score:</strong>
            ${bestScore}
        </p>

    `;


    updateResultHeading(
        "Recommended Mobile"
    );

}


/* =========================================================
   CAREER RECOMMENDATION
   ========================================================= */

function recommendCareer() {

    const demand =
        Number(
            document.querySelector("#demand")?.value
        );

    const difficulty =
        Number(
            document.querySelector("#difficulty")?.value
        );


    if (!demand || !difficulty) {

        showFormMessage(
            "Please select demand and difficulty."
        );

        return;

    }


    const careers = [

        {
            name: "Java Developer",
            skill: "Java, SQL, Spring Boot",
            salary: 600000,
            demand: 9,
            difficulty: 7
        },

        {
            name: "Web Developer",
            skill: "HTML, CSS, JavaScript",
            salary: 500000,
            demand: 8,
            difficulty: 6
        },

        {
            name: "Data Analyst",
            skill: "SQL, Excel, Python",
            salary: 550000,
            demand: 8,
            difficulty: 7
        },

        {
            name: "Software Tester",
            skill: "Testing, SQL, Automation",
            salary: 450000,
            demand: 7,
            difficulty: 6
        }

    ];


    let bestCareer = null;

    let bestScore = -1;


    careers.forEach(function (career) {

        if (

            career.demand >= demand &&
            career.difficulty <= difficulty

        ) {

            const score =
                career.demand +
                (10 - career.difficulty);


            if (score > bestScore) {

                bestScore = score;

                bestCareer = career;

            }

        }

    });


    if (!bestCareer) {

        showResultMessage(
            "No career matched your selected requirements."
        );

        return;

    }


    const details =
        document.querySelector(".result-details");


    if (!details) {
        return;
    }


    details.innerHTML = `

        <p>
            <strong>Career:</strong>
            ${bestCareer.name}
        </p>

        <p>
            <strong>Main Skill:</strong>
            ${bestCareer.skill}
        </p>

        <p>
            <strong>Salary:</strong>
            ₹${bestCareer.salary.toLocaleString("en-IN")} / year
        </p>

        <p>
            <strong>Demand:</strong>
            ${bestCareer.demand}/10
        </p>

        <p>
            <strong>Difficulty:</strong>
            ${bestCareer.difficulty}/10
        </p>

        <p>
            <strong>Score:</strong>
            ${bestScore}
        </p>

    `;


    updateResultHeading(
        "Career Recommendation"
    );

}


/* =========================================================
   TRAVEL RECOMMENDATION
   ========================================================= */

function recommendTravel() {

    const budget =
        Number(
            document.querySelector("#budget")?.value
        );

    const adventure =
        Number(
            document.querySelector("#adventure")?.value
        );

    const relaxation =
        Number(
            document.querySelector("#relaxation")?.value
        );


    if (
        !budget ||
        !adventure ||
        !relaxation
    ) {

        showFormMessage(
            "Please enter budget, adventure and relaxation requirements."
        );

        return;

    }


    const destinations = [

        {
            name: "Goa",
            budget: 8000,
            duration: "3 Days",
            adventure: 8,
            relaxation: 8
        },

        {
            name: "Manali",
            budget: 10000,
            duration: "4 Days",
            adventure: 9,
            relaxation: 7
        },

        {
            name: "Mysore",
            budget: 5000,
            duration: "2 Days",
            adventure: 6,
            relaxation: 8
        },

        {
            name: "Ooty",
            budget: 7000,
            duration: "3 Days",
            adventure: 6,
            relaxation: 9
        },

        {
            name: "Rishikesh",
            budget: 9000,
            duration: "4 Days",
            adventure: 10,
            relaxation: 7
        }

    ];


    let bestDestination = null;

    let bestScore = -1;


    destinations.forEach(function (destination) {

        if (

            destination.budget <= budget &&
            destination.adventure >= adventure &&
            destination.relaxation >= relaxation

        ) {

            const score =
                destination.adventure +
                destination.relaxation;


            if (score > bestScore) {

                bestScore = score;

                bestDestination = destination;

            }

        }

    });


    if (!bestDestination) {

        showResultMessage(
            "No destination matched your budget and preferences."
        );

        return;

    }


    const details =
        document.querySelector(".result-details");


    if (!details) {
        return;
    }


    details.innerHTML = `

        <p>
            <strong>Destination:</strong>
            ${bestDestination.name}
        </p>

        <p>
            <strong>Budget:</strong>
            ₹${bestDestination.budget.toLocaleString("en-IN")}
        </p>

        <p>
            <strong>Duration:</strong>
            ${bestDestination.duration}
        </p>

        <p>
            <strong>Adventure:</strong>
            ${getLevel(bestDestination.adventure)}
        </p>

        <p>
            <strong>Relaxation:</strong>
            ${getLevel(bestDestination.relaxation)}
        </p>

        <p>
            <strong>Score:</strong>
            ${bestScore}
        </p>

    `;


    updateResultHeading(
        "Travel Recommendation"
    );

}


/* =========================================================
   LEVEL CONVERTER
   ========================================================= */

function getLevel(value) {

    if (value <= 6) {
        return "Basic";
    }

    if (value === 7) {
        return "Good";
    }

    if (value === 8) {
        return "High";
    }

    if (value === 9) {
        return "Very High";
    }

    return "Excellent";

}


/* =========================================================
   RESULT HEADING
   ========================================================= */

function updateResultHeading(text) {

    const heading =
        document.querySelector(".result h2");


    if (heading) {

        heading.textContent = text;

    }


    const result =
        document.querySelector(".result");


    if (result) {

        result.scrollIntoView({

            behavior: "smooth",

            block: "start"

        });

    }

}


/* =========================================================
   FORM MESSAGE
   ========================================================= */

function showFormMessage(message) {

    let messageBox =
        document.querySelector(".form-message");


    if (!messageBox) {

        messageBox =
            document.createElement("p");

        messageBox.className =
            "form-message";


        const form =
            document.querySelector(".laptop-form");


        if (form) {

            form.appendChild(messageBox);

        }

    }


    messageBox.textContent = message;

}


/* =========================================================
   RESULT MESSAGE
   ========================================================= */

function showResultMessage(message) {

    const details =
        document.querySelector(".result-details");


    if (!details) {
        return;
    }


    details.innerHTML = `

        <p class="error-message">
            ${message}
        </p>

    `;


    updateResultHeading(
        "No Recommendation Found"
    );

}


/* =========================================================
   REMOVE OLD FORM MESSAGE
   ========================================================= */

function removeFormMessage() {

    const message =
        document.querySelector(".form-message");


    if (message) {

        message.remove();

    }

}


/* =========================================================
   REMOVE FORM MESSAGE WHEN USER CHANGES INPUT
   ========================================================= */

const formInputs =
    document.querySelectorAll(
        ".laptop-form input, .laptop-form select"
    );


formInputs.forEach(function (input) {

    input.addEventListener(
        "change",
        removeFormMessage
    );

    input.addEventListener(
        "input",
        removeFormMessage
    );

});