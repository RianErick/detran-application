import styles from './styles/Table.module.css'
import { Children } from "react";

type TableProperties = {
    children: React.ReactNode;
}

export default function Table({ children }:TableProperties){

    return (
        <div className={`${styles.tableDiv}`}>
            <table className={styles.table}>
                {children}
            </table>
        </div>
    )
}