import React, { memo } from 'react';

export const ControlBar = memo(({ showFormAddDrug, filterDrugsByPrice, limitBelow, limitAbove }) => {
    const handleFormAddDrug = () => {
        lockConfirmBtn();
        showFormAddDrug();
    }
    
    const lockConfirmBtn = () => {
        let confirmBtn = document.getElementById('confirmBtn');
        confirmBtn.removeAttribute('data-dismiss');
    }

    return (
        <div className="container my-5">
            <div className="d-flex justify-content-between align-items-start mb-4">
                <button type="button" id="addDrugBtn" onClick={ handleFormAddDrug } className="btn btn-success" 
                    data-toggle="modal" data-target="#drugModalForm" >Dodaj</button>
                
                <div className="row m-0">
                    <label className="col-lg-3 col-form-label form-control-label text-right px-3">Cena [zł]: </label>
                    <div className="col-lg-4 px-0">
                        <input id="priceFromInput" className="form-control" type="number" placeholder="Od" min="0" step="0.01"
                            onChange={ event => filterDrugsByPrice(event.target.value, limitAbove) }
                            onKeyUp={ event => filterDrugsByPrice(event.target.value, limitAbove) } />
                    </div>
                    <label className="col-lg-1 col-form-label text-center px-0"> - </label>
                    <div className="col-lg-4 px-0">
                        <input id="priceToInput" className="form-control" type="number" placeholder="Do" min="0" step="0.01"
                            onChange={ event => filterDrugsByPrice(limitBelow, event.target.value) }
                            onKeyUp={ event => filterDrugsByPrice(limitBelow, event.target.value) } />
                    </div>
                </div>
            </div>
        </div>
    );
});