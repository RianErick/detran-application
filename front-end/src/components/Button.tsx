
type ButtonProperties = {
    id?: string;
    children?: React.ReactNode;
    className?: string;
    color?: string;
}

export default function Button({ children, className, id, color }:ButtonProperties){

    let button_id = id ?? ""
    let applyColor = color ?? "blue"

    let defaultStyle = `transition text-white font-bold p-2 bg-blue-500 rounded-sm`
    let hoverStyle = `hover:bg-blue-400`
    let activeStyle = `active:bg-blue-500`

    let classStyles = [
        className,
        defaultStyle,
        hoverStyle,
        activeStyle
    ].join(" ");


    return (
        <button id={button_id} className={classStyles}>
            {children}
        </button>
    );
}