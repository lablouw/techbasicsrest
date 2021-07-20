package techbasics.restservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StringUtils;

@Aspect
@Slf4j
public class RestBoundaryLoggerAspect {

    //Pointcut definitions
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restController() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putMapping() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMapping() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void patchMapping() {//No implementation required
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {//No implementation required
    }

    @Around("restController() && (getMapping() || putMapping() || postMapping() || deleteMapping() || patchMapping() || requestMapping())")
    public Object logRestApiCall(ProceedingJoinPoint pjp) throws Throwable {
        String argsPattern = "";
        for (int i = 0; i < pjp.getArgs().length; i++) {
            argsPattern += "{}, ";
        }
        argsPattern = StringUtils.isEmpty(argsPattern) ? argsPattern : argsPattern.substring(0, argsPattern.length() - 2);

        String method = pjp.getSignature().getName();

        log.info("Inbound: [method={}, args=" + argsPattern + "]", method, pjp.getArgs());
        Object ret = pjp.proceed();
        log.info("Outbound: [method={}, response={}]", method, ret);
        return ret;

    }
}
