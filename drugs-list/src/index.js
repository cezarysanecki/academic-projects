import React from 'react';
import ReactDOM from 'react-dom';
import { FilterableDrugTable } from './components/FilterableDrugTable';

import drugList from './db/drugs.json';

import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery/dist/jquery.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

ReactDOM.render(
    <FilterableDrugTable drugs={ drugList.drugs }/>,
    document.getElementById('root')
);