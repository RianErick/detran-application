import Link from 'next/link'
import Input from '@/components/Input'
import Button from '@/components/Button'
import Checkbox from '@/components/Checkbox'

export default function LoginPage(){
    return (
        <div className="flex flex-col">
            <div className="flex place-items-center w-20 h-20 p-3 mt-8 m-2 bg-white rounded-lg shadow-lg place-self-center">
                <img src="https://www.seinfra.ce.gov.br/wp-content/uploads/sites/10/2019/08/logo-detran.png" alt="logo" />
            </div>

            <div className="mt-4 place-self-center text-2xl font-bold">Login</div>
            <form className='w-full px-12 mt-8 place-self-center'>
                <Input type="email" placeholder='exemplo@email.com' label='Email'/>
                <Input type="password" placeholder='********' label='Senha'/>

                <div className="flex mt-2 place-items-center justify-between">
                    <Checkbox name="Me lembre" />
                    <Link className="text-sm underline text-sky-900 transition hover:text-sky-700" href="/recovery">Esqueceu a senha?</Link>
                </div>

                <div className="flex mt-8">
                    <Button className="w-full">Entrar</Button>
                </div>
            </form>

        </div>
    )
}