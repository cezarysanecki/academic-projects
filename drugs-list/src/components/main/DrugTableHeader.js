import React, { memo } from 'react';
import '../../css/main.css';

export const DrugTableHeader = memo(({ sortById, sortByName, sortByPrice, sortByProducer, ascSort, removeSortSigns }) => {
    const addSortSign = (elem) => {
        let htmlElement = elem.target;

        if(ascSort) {
            htmlElement.classList.add('headerSortDown');
        } else {
            htmlElement.classList.add('headerSortUp');
        }
    }

    const handleSortById = (elem) => {
        removeSortSigns();
        addSortSign(elem);
        sortById();
    }

    const handleSortByName = (elem) => {
        removeSortSigns();
        addSortSign(elem);
        sortByName();
    }

    const handleSortByPrice = (elem) => {
        removeSortSigns();
        addSortSign(elem);
        sortByPrice();
    }

    const handleSortByProducer = (elem) => {
        removeSortSigns();
        addSortSign(elem);
        sortByProducer();
    }

    return (
        <thead className="thead-light">
            <tr>
                <th className="sortableColumn" onClick={ handleSortById } scope="col">ID</th>
                <th className="sortableColumn" onClick={ handleSortByName } scope="col">Nazwa</th>
                <th className="sortableColumn" onClick={ handleSortByPrice } scope="col">Cena</th>
                <th className="sortableColumn" onClick={ handleSortByProducer } scope="col">Producent</th>
                <th scope="col">Operacje</th>
            </tr>
        </thead>
    );
});