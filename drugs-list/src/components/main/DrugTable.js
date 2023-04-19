import React, { useState, memo } from 'react';

import { DrugTableHeader } from './DrugTableHeader';
import { DrugTableBody } from './DrugTableBody';

export const DrugTable = memo(({ drugs, setDrugs, onDeleteDrug, showFormEditDrug, showInfoDrugWindow, removeSortSigns }) => {
    const [ascSort, setAscSort] = useState(false);
    
    const sortById = () => {
        setAscSort(!ascSort);

        if(ascSort) {
            setDrugs([].concat(drugs.sort((a, b) => (a.id - b.id))));
        } else {
            setDrugs([].concat(drugs.sort((a, b) => (b.id - a.id))));
        }
    }

    const sortByName = () => {
        setAscSort(!ascSort);

        if(ascSort) {
            setDrugs([].concat(drugs.sort((a, b) => (a.name.localeCompare(b.name)))));
        } else {
            setDrugs([].concat(drugs.sort((a, b) => (b.name.localeCompare(a.name)))));
        }
    }

    const sortByPrice = () => {
        setAscSort(!ascSort);

        if(ascSort) {
            setDrugs([].concat(drugs.sort((a, b) => (a.price - b.price))));
        } else {
            setDrugs([].concat(drugs.sort((a, b) => (b.price - a.price))));
        }
    }

    const sortByProducer = () => {
        setAscSort(!ascSort);

        if(ascSort) {
            setDrugs([].concat(drugs.sort((a, b) => (a.producer.localeCompare(b.producer)))));
        } else {
            setDrugs([].concat(drugs.sort((a, b) => (b.producer.localeCompare(a.producer)))));
        }
    }

    return (
        <table className="table table-hover mt-3">
            <DrugTableHeader sortById={ sortById } sortByName={ sortByName } sortByPrice={ sortByPrice } 
                sortByProducer={ sortByProducer } ascSort={ ascSort } removeSortSigns={ removeSortSigns } />
            <DrugTableBody drugs={ drugs } onDeleteDrug={ onDeleteDrug } showFormEditDrug={ showFormEditDrug } showInfoDrugWindow={ showInfoDrugWindow } />
        </table>
    );
});