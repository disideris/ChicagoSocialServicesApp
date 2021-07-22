import { API_BASE_URL, QUERY_LIST_SIZE, ACCESS_TOKEN } from '../constants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })

    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response =>
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

export function getIncidentsByAddress(page, size, address) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/incidents/addressIncidents?page=" + page + "&size=" + size + "&address=" + address,
        method: 'GET'
    });
}

export function getIncidentsByZip(page, size, zip) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/incidents/zipIncidents?page=" + page + "&size=" + size + "&zip=" + zip,
        method: 'GET'
    });
}

export function getFunc1Results(page, size, startDate, endDate) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/incidents/func1?page=" + page + "&size=" + size + "&start_date=" + startDate + "&end_date=" + endDate,
        method: 'GET'
    });
}

export function getFunc2Results(page, size, type, startDate, endDate) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/incidents/func2?page=" + page + "&size=" + size +  "&service_type=" + type + "&start_date=" + startDate + "&end_date=" + endDate,
        method: 'GET'
    });
}

export function getFunc3Results(page, size, someDay) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/incidents/func3?page=" + page + "&size=" + size + "&some_day=" + someDay,
        method: 'GET'
    });
}

export function createIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newGenericIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createGraffitiIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newGraffitiIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createGarbageCartIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newGarbageCartIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createPotholeIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newPotholeIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createRodentIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newRodentIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createSanitationIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newSanitationIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createTreeDebrisIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newTreeDebrisIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createTreeTrimsIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newTreeTrimsIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function createVehicleIncident(incidentData) {
    return request({
        url: API_BASE_URL + "/incidents/newVehicleIncident",
        method: 'POST',
        body: JSON.stringify(incidentData)
    });
}

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: API_BASE_URL + "/auth/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}

export function checkUsernameAvailability(username) {
    return request({
        url: API_BASE_URL + "/user/checkUsernameAvailability?username=" + username,
        method: 'GET'
    });
}

export function checkEmailAvailability(email) {
    return request({
        url: API_BASE_URL + "/user/checkEmailAvailability?email=" + email,
        method: 'GET'
    });
}


export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/user/me",
        method: 'GET'
    });
}

export function getUserProfile(username) {
    return request({
        url: API_BASE_URL + "/users/" + username,
        method: 'GET'
    });
}

export function getUserQueryData(username, page, size) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/users/" + username + "/userQueryData?page=" + page + "&size=" + size,
        method: 'GET'
    });
}

export function getUserInsertions(username, page, size) {
    page = page || 0;
    size = size || QUERY_LIST_SIZE;

    return request({
        url: API_BASE_URL + "/users/" + username + "/userInsertions?page=" + page + "&size=" + size,
        method: 'GET'
    });
}
