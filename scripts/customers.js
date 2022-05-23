class Customer {
    constructor(id, fullName, phoneNumber, email, address, balance) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }
}

var customers = [];

const customerData = "customerData";

function init() {
    if (getLocalStorage(customerData) == null) {
        customers = [
            new Customer(1, "Dao Lan Anh", "0432365236", "lananhdao@gmail.com", "Quang Tri", 3000000),
            new Customer(2, "Nguyen Duy Hung", "0645746334", "hungduy@gmail.com", "Ha Noi", 9500000000),
            new Customer(3, "Phan The Tai", "0564535123", "tai99999@gmail.com", "Phu Yen", 7890000000),
        ]
        setLocalStorage(customerData, customers);
        return;
    }
    customers = getLocalStorage(customerData);
}

function setLocalStorage(key, data) {
    localStorage.setItem(key, JSON.stringify(data))
}

function getLocalStorage(key) {
    return JSON.parse(localStorage.getItem(key))
}

function renderCustomers() {
    let htmls = customers.map(function (customer) {
        return `
        <tr>
            <td>
                <input type="checkbox">
            </td>
            <td class = "align-center">${customer.id}</td>
            <td>${customer.fullName}</td>
            <td>${customer.email}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.address}</td>
            <td class="align-right">${customer.balance}</td>
            <td id = "action">
                <a href="/services/updateInfo.html">
                    <i title="Edit" class="fa-solid fa-user-pen edit"></i>
                </a>
                <a href="/services/deposit.html">
                    <i title="Deposit" class="fa-solid fa-circle-plus deposit"></i>
                </a>
                <a href="/services/withdraw.html">
                    <i title="Withdraw" class="fa-solid fa-circle-minus withdraw"></i>
                </a>
                <a href="/services/transfer.html">
                    <i title="Transfer" class="fa-solid fa-arrow-right-arrow-left transfer"></i>
                </a>
                <a href="/services/remove.html">
                    <i title="Remove" class="fa-solid fa-trash remove"></i>
                </a>
            </td>
        </tr>`
    })
    document.querySelector("#tbCustomers>tbody").innerHTML = htmls.join("")
}

(function () {
    init();
    renderCustomers();
})()
