const baseUrl = "http://localhost:8080"; // Make sure this is the correct base URL for your backend

// Set database
async function setDatabase() {
    const databaseType = document.getElementById("databaseType").value;
    const fileName = document.getElementById("fileName").value;

    const url = `${baseUrl}/setDataBase?dataBaseType=${encodeURIComponent(databaseType)}&fileName=${encodeURIComponent(fileName)}`;

    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'OData-Version': '4.0',
                'Content-Type': 'application/json;odata.metadata=minimal'
            }
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.statusText}`);
        }

        const result = await response.text();
        document.getElementById("setDatabaseResult").innerText = result;
    } catch (error) {
        document.getElementById("setDatabaseResult").innerText = `Error: ${error.message}`;
    }
}


// Write to database
async function writeDatabase() {
    const fileName = document.getElementById("writeFileName").value;

    const url = `${baseUrl}/writeDataBase?fileName=${fileName}`;
    const response = await fetch(url);

    const result = await response.text();
    document.getElementById("writeDatabaseResult").innerText = result;
}

// Get fields
async function getFields() {
    const url = `${baseUrl}/getFields`;
    const response = await fetch(url);

    const result = await response.text();
    document.getElementById("fieldsResult").innerText = result;
}

// Get field types
async function getFieldTypes() {
    const url = `${baseUrl}/getType`;
    const response = await fetch(url);

    const result = await response.text();
    document.getElementById("fieldTypesResult").innerText = result;
}

// Get masking
async function getMasking() {
    const url = `${baseUrl}/getMasking`;
    const response = await fetch(url);

    const result = await response.text();
    document.getElementById("maskingResult").innerText = result;
}

// Set fields
async function setFields() {
    const fieldsData = document.getElementById("fieldsData").value.split(',');

    const url = `${baseUrl}/setFields`;
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(fieldsData),
    });

    const result = await response.text();
    document.getElementById("setFieldsResult").innerText = result;
}

// Set field types
async function setTypes() {
    const typesData = document.getElementById("typesData").value.split(',');

    const url = `${baseUrl}/setType`;
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(typesData),
    });

    const result = await response.text();
    document.getElementById("setTypesResult").innerText = result;
}

// Set masking
async function setMasking() {
    const maskingData = document.getElementById("maskingData").value.split(',');

    const url = `${baseUrl}/setMasking`;
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(maskingData),
    });

    const result = await response.text();
    document.getElementById("setMaskingResult").innerText = result;
}
