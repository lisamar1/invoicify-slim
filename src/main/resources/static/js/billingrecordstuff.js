$(function() {

    $('#create-flat-fee-record').submit(function(e) {
        e.preventDefault();

        let flatFee = {
            amount: $('#flat-fee-amount').val(),
            description: $('#flat-fee-description').val(),
            client: { id: $('#flat-fee-clientId').val() }
        };
        let headers = {
            'X-CSRF-TOKEN': $('#flat-fee-csrf').val()    
        };
        
        let settings = {
            url: '/api/billing-records/flats',
            headers: headers,
            data: JSON.stringify(flatFee),
            contentType: 'application/json'
        };
        
        $.post(settings)
        .done(function (data) {
            $('#billingRecord-table')
                .append(`
                    <tr>
                     <td>${ data.createdBy.username }</td>
                        <td>${ data.description }</td>
                        <td>${ data.client.name }</td>
                        <td>${ data.amount }</td>
                        <td>${ data.rate }</td>
                        <td>${ data.quantity }</td>
                        <td>${ data.total }</td>
                	</tr>
                		`);
            $('#billingRecord-name').val('');
        });
    });
});

$(function() {

    $('#create-rate-based-record').submit(function(e) {
        e.preventDefault();

        let billingRecord = {
        	rate: $('#rate').val(),
            quantity: $('#quantity').val(),
            description: $('#rate-based-description').val(),
            client: { id: $('#rate-based-clientId').val() }
        };
        let headers = {
            'X-CSRF-TOKEN': $('#create-record-based-record-csrf').val()    
        };
        
        let settings = {
            url: '/api/billing-records/rates',
            headers: headers,
            data: JSON.stringify(billingRecord),
            contentType: 'application/json'
        };
        
        $.post(settings)
        .done(function (data) {
            $('#billingRecord-table')
                .append(`
                    <tr>
                        <td>${ data.createdBy.username }</td>
                        <td>${ data.description }</td>
                        <td>${ data.client.name }</td>
                        <td>${ data.amount }</td>
                        <td>${ data.rate }</td>
                        <td>${ data.quantity }</td>
                        <td>${ data.total }</td>
                    </tr>
                `);
            
            $('#create-rate-based-record .amount').val('');
            $('#create-rate-based-record .description').val('');
        });
    });    
});
