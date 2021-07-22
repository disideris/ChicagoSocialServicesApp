const colors = [
    '#F44336', '#e91e63', '#9c27b0', '#673ab7',
    '#ff9800', '#ff5722', '#795548', '#607d8b',
    '#3f51b5', '#2196F3', '#00bcd4', '#009688',
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0',
    '#4CAF50', '#ffeb3b', '#ffc107',
];

export function getAvatarColor(name) {
    if (name == null) {
        return;
    }
    name = name.substr(0, 12);

    var hash = 0;
    for (var i = 0; i < name.length; i++) {
        hash = 31 * hash + name.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

export function getAvatarColorByDate(name) {

    if (name.includes("Jan")) {
        return colors[0];
    } else if (name.includes("Feb")) {
        return colors[2];
    } else if (name.includes("Mar")) {
        return colors[4];
    } else if (name.includes("Apr")) {
        return colors[6];
    } else if (name.includes("May")) {
        return colors[8];
    } else if (name.includes("Jun")) {
        return colors[10];
    } else if (name.includes("Jul")) {
        return colors[12];
    } else if (name.includes("Aug")) {
        return colors[14];
    } else if (name.includes("Sep")) {
        return colors[16];
    } else if (name.includes("Oct")) {
        return colors[18];
    } else if (name.includes("Nov")) {
        return colors[3];
    } else if (name.includes("Dec")) {
        return colors[9];
    } else {
        return colors[1];
    }
}

export function getAvatarStatusColor(status) {

    if (status != null && status.includes("Completed")){
        return colors[13];
    } else {
        return colors[1];
    }
}